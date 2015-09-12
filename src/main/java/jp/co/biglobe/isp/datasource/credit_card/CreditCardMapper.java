package jp.co.biglobe.isp.datasource.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditEntity;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditCardMapper {

    public void register(
            @Param("validCreditEntity") ValidCreditEntity validCreditEntity
    );

    public ValidCreditEntity クレジットカード番号で検索する(
            @Param("creditCardNumber") CreditCardNumber creditCardNumber
    );

    public List<CreditEntity> findAll();
}
