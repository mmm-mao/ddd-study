package jp.co.biglobe.isp.datasource.credit_card;


import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.outsource.domain.クレジットカードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardRepositoryDb implements CreditCardRepository {

    @Autowired
    private クレジットカードのドメイン creditCardDomain;

    @Autowired
    private CreditCardQueryMapper creditCardQueryMapper;

    @Override
    public CreditEntity クレジットカード番号で検索する(CreditCardNumber creditCardNumber) {
        return creditCardQueryMapper.findByCreditCard(creditCardNumber);
    }

    @Override
    public ValidCreditEntity クレジットカード番号で検索する_存在しなかったらエラー(CreditCardNumber creditCardNumber) {
        return creditCardQueryMapper.findByCreditCard(creditCardNumber);
    }

    @Override
    public ValidCreditEntity _biglobeIdで検索する(BiglobeId biglobeId) {
        return new ValidCreditEntity(
                new CreditCardNumber("111-111-1111"),
                biglobeId,
                ValidCreditCardStatus.有効
        );
    }


    @Override
    public ValidCreditCardStatus 有効かチェックする(CreditCard creditCard) {

        boolean result = creditCardDomain.check(
                creditCard.getCreditCardNumber().getValue(),
                creditCard.getEffectiveMonth().getValue(),
                creditCard.getSecurityNumber().getValue().toString()
        );


        return ValidCreditCardStatus.作成する(result);


    }

    @Override
    public void 登録する(ValidCreditEntity validCreditCardEntity) {

        creditCardQueryMapper.register(validCreditCardEntity);
    }

    @Override
    public void 有効に戻す(ValidCreditEntity validCreditCardEntity) {
    }

    @Override
    public void 無効にする(ValidCreditEntity validCreditCardEntity) {
    }

    @Override
    public void 変更する(ValidCreditEntity validCreditCardEntity) {
    }

    @Override
    public void 送付されてきたクレジットカード情報が無効だと通知する(BiglobeId biglobeId) {
    }

    @Override
    public void 無効になったことを通知する(BiglobeId biglobeId) {
    }
}
