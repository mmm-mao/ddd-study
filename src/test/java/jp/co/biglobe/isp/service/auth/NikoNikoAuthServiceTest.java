package jp.co.biglobe.isp.service.auth;


import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.member.BiglobeId;
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
public class NikoNikoAuthServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private NikoNikoAuthService nikoNikoAuthService;



    @Test(expected = UnsupportedOperationException.class)
    public void ベーシックコースなので_認証不可() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));


        nikoNikoAuthService.受け付ける(validAuth);

    }

    @Test
    public void ニコニココースなので_認証不可() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.ニコニココースで受付済み());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));


        nikoNikoAuthService.受け付ける(validAuth);

    }



}
