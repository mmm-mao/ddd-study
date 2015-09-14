package jp.co.biglobe.isp.datasource.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditEntity;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditCardQueryMapper {

    public void register(
            @Param("validCreditEntity") ValidCreditEntity validCreditEntity
    );

    public void validRegister(
            @Param("validCreditEntity") ValidCreditEntity validCreditEntity
    );

    public ValidCreditEntity findByCreditCard(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

}
