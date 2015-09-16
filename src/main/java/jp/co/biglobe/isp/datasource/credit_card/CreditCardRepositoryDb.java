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
        ValidCreditEntity validCreditEntity = creditCardQueryMapper.findByCreditCard(creditCardNumber);

        if(validCreditEntity == null){
            return new NotExistCreditEntity();
        }

        return validCreditEntity;
    }

    @Override
    public ValidCreditEntity クレジットカード番号で検索する_存在しなかったらエラー(CreditCardNumber creditCardNumber) {
        return judgeValidOrException(creditCardQueryMapper.findByCreditCard(creditCardNumber));
    }

    @Override
    public ValidCreditEntity biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId) {
        return judgeValidOrException(creditCardQueryMapper.findByBiglobeId(biglobeId));
    }

    private ValidCreditEntity judgeValidOrException(ValidCreditEntity validCreditEntity) {

        if (validCreditEntity == null) {
            throw new UnsupportedOperationException("クレジットカードが存在しない");
        }
        return validCreditEntity;
    }

    @Override
    public ValidCreditCardStatus 有効かチェックする(CreditCard creditCard) {

        boolean result = creditCardDomain.check(
                creditCard.getCreditCardNumber().getValue(),
                creditCard.getEffectiveMonth().get有効かチェックする値(),
                creditCard.getSecurityNumber().getValue().toString()
        );


        return ValidCreditCardStatus.作成する(result);


    }

    @Override
    public void 登録する(ValidCreditEntity validCreditCardEntity) {

        creditCardQueryMapper.register(validCreditCardEntity);
        creditCardQueryMapper.validRegister(validCreditCardEntity);
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
