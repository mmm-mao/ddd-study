package jp.co.biglobe.isp.datasource.credit_card;


import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditCardStatus;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.dbunit.DatabaseUnitException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/db/V1__create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class CreditCardRepositoryDbTest {

//    @Autowired
//    public DbUnitTester tester;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Before
    public void setup() throws IOException, DatabaseUnitException, SQLException {
        // 処理前にテーブルをクリアする
        //tester.executeAllClearTableAndSeq();

        // 「現在時刻」を固定化する
        //CurrentLocalDateTimeCreator.setTestClock(TestClock.DEFAULT);
    }

    @Test
    public void aaa(){

        ValidCreditEntity validCreditEntity = new ValidCreditEntity(
                new CreditCardNumber("111-111-1111"),
                new BiglobeId("abc12345"),
                ValidCreditCardStatus.有効
        );


        creditCardRepository.登録する(validCreditEntity);

        ValidCreditEntity b = creditCardRepository.クレジットカード番号で検索する_存在しなかったらエラー(new CreditCardNumber("111-111-1111"));

        assertThat(validCreditEntity, is(b));
    }
}
