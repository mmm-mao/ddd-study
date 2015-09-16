package jp.co.biglobe.isp.datasource.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.ValidCredit;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.apache.ibatis.annotations.Param;

public interface CreditCardQueryMapper {

    public void register(
            @Param("validCreditEntity") ValidCredit validCreditEntity
    );

    public void validRegister(
            @Param("validCreditEntity") ValidCredit validCreditEntity
    );

    public void delete(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

    public void validDelete(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

    public ValidCredit findByCreditCard(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

    public ValidCredit findByBiglobeId(
            @Param("biglobeId") BiglobeId biglobeId
    );

}
