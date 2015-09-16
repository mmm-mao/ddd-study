package jp.co.biglobe.isp.datasource.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.apache.ibatis.annotations.Param;

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

    public ValidCreditEntity findByBiglobeId(
            @Param("biglobeId") BiglobeId biglobeId
    );

}
