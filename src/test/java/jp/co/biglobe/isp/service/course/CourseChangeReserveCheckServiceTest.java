package jp.co.biglobe.isp.service.course;


import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/sql/drop-tables.sql",
        "/db/V1_create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class CourseChangeReserveCheckServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private CourseChangeReserveCheckService courseChangeReserveCheckService;



    @Test
    public void 違うコースへの変更なのでOK() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());


        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ニコニコ);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void 同じコースへの変更なのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void 退会済みなのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.退会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void コース変更予約中なのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.Two.コース変更予約中());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }




}
