package jp.co.biglobe.isp.datasource.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditEntity;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditCardQueryMapper {

    public void _register(
            @Param("validCreditEntity") ValidCreditEntity validCreditEntity
    );

    public void _validRegister(
            @Param("validCreditEntity") ValidCreditEntity validCreditEntity
    );

    public ValidCreditEntity _findByCreditCard(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

}
