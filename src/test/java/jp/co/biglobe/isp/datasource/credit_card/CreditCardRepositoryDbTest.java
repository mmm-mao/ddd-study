package jp.co.biglobe.isp.datasource.credit_card;


import jp.co.biglobe.isp.datasource.credit_card.assertion.CreditAssert;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditCardStatus;
import jp.co.biglobe.isp.domain.credit_card.ValidCredit;
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
public class CreditCardRepositoryDbTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private CreditCardRepository creditCardRepository;


    @Test
    public void 登録する() throws Exception {

        ValidCredit validCreditEntity = new ValidCredit(
                new CreditCardNumber("111-111-1111"),
                new BiglobeId("abc12345"),
                ValidCreditCardStatus.有効
        );


        creditCardRepository.登録する(validCreditEntity);

        CreditAssert creditAssert = new CreditAssert(tester);
        creditAssert.assertTableWithAllColumns(FixtureCredit.One.有効で登録済み());

    }

    @Test
    public void クレジットカード番号で検索する_存在しなかったらエラー() throws Exception {

        ValidCredit expected = new ValidCredit(
                new CreditCardNumber("111-111-1111"),
                new BiglobeId("abc12345"),
                ValidCreditCardStatus.有効
        );


        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());

        ValidCredit actual = creditCardRepository.クレジットカード番号で検索する_存在しなかったらエラー(new CreditCardNumber("111-111-1111"));

        assertThat(expected, is(actual));
    }
}
