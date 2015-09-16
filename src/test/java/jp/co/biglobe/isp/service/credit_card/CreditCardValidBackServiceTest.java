package jp.co.biglobe.isp.service.credit_card;


import jp.co.biglobe.isp.datasource.credit_card.assertion.CreditAssert;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.domain.credit_card.CreditCard;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.EffectiveMonth;
import jp.co.biglobe.isp.domain.credit_card.SecurityNumber;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.YearMonth;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/sql/drop-tables.sql",
        "/db/V1_create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class CreditCardValidBackServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private CreditCardValidBackService creditCardValidBackService;



    @Test
    public void 有効に戻す() throws Exception {

        Map map = FixtureCredit.One.無効にする();
        tester.cleanInsertQuery(FixtureCredit.One.無効にする());

        CreditCard creditCard = new CreditCard(new CreditCardNumber("111-111-1111"), new EffectiveMonth(YearMonth.now()), new SecurityNumber(123456789));

        creditCardValidBackService.受け付ける(new BiglobeId("abc12345"), creditCard);

        CreditAssert creditAssert = new CreditAssert(tester);
        creditAssert.assertTableWithAllColumns(FixtureCredit.One.有効に戻す());

    }


}
