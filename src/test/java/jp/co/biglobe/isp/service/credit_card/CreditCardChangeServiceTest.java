package jp.co.biglobe.isp.service.credit_card;


import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.isp.datasource.credit_card.assertion.CreditAssert;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.datasource.member.assertion.MemberAssert;
import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.credit_card.CreditCard;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.EffectiveMonth;
import jp.co.biglobe.isp.domain.credit_card.SecurityNumber;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.service.member.WithdrawalService;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.YearMonth;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/sql/drop-tables.sql",
        "/db/V1_create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class CreditCardChangeServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private CreditCardChangeService creditCardChangeService;



    @Test
    public void 変更OK() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new BiglobeId("abc12345"), new Password("password"));
        CreditCard creditCard = new CreditCard(new CreditCardNumber("111-111-1112"), new EffectiveMonth(YearMonth.now()), new SecurityNumber(123456789));



        creditCardChangeService.受け付ける(validAuth, creditCard);

        CreditAssert creditAssert = new CreditAssert(tester);
        creditAssert.assertTableWithAllColumns(FixtureCredit.One.有効で変更済み());

    }


}
