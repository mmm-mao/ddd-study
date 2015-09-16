package jp.co.biglobe.isp.service.auth;


import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.isp.domain.auth.UserPassword;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.service.course.CourseChangeReserveCheckService;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/sql/drop-tables.sql",
        "/db/V1_create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class BiglobeAuthServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private BiglobeAuthService biglobeAuthService;



    @Test
    public void 認証OK() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());

        ValidAuth validAuth = new ValidAuth(new UserId("abc12345"), new UserPassword("password"));


        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

    }



}
