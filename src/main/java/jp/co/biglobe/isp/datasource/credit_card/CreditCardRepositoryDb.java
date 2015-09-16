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
    public Credit クレジットカード番号で検索する(CreditCardNumber creditCardNumber) {
        ValidCredit validCreditEntity = creditCardQueryMapper.findByCreditCard(creditCardNumber);

        if(validCreditEntity == null){
            return new NotExistCredit();
        }

        return validCreditEntity;
    }

    @Override
    public ValidCredit クレジットカード番号で検索する_存在しなかったらエラー(CreditCardNumber creditCardNumber) {
        return judgeValidOrException(creditCardQueryMapper.findByCreditCard(creditCardNumber));
    }

    @Override
    public ValidCredit biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId) {
        return judgeValidOrException(creditCardQueryMapper.findByBiglobeId(biglobeId));
    }

    private ValidCredit judgeValidOrException(ValidCredit validCreditEntity) {

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
    public void 登録する(ValidCredit validCreditCardEntity) {

        creditCardQueryMapper.register(validCreditCardEntity);
        creditCardQueryMapper.validRegister(validCreditCardEntity);
    }

    @Override
    public void 有効に戻す(ValidCredit validCreditCardEntity) {
        creditCardQueryMapper.validRegister(validCreditCardEntity);
    }

    @Override
    public void 無効にする(ValidCredit validCreditCardEntity) {
        creditCardQueryMapper.validRegister(validCreditCardEntity);
    }

    @Override
    public void 変更する(ValidCredit validCreditCardEntity) {
        削除する(validCreditCardEntity);

        登録する(validCreditCardEntity);
    }

    private void 削除する(ValidCredit validCreditCardEntity){

        ValidCredit validCreditEntity = biglobeIdで検索する_存在しなかったらエラー(validCreditCardEntity.getBiglobeId());
        creditCardQueryMapper.validDelete(validCreditEntity.getCreditCardNumber());
        creditCardQueryMapper.delete(validCreditEntity.getCreditCardNumber());
    }

    @Override
    public void 送付されてきたクレジットカード情報が無効だと通知する(BiglobeId biglobeId) {
        // 今回は通知手段は決めてないので、何もしない。
    }

    @Override
    public void 無効になったことを通知する(BiglobeId biglobeId) {
        // 今回は通知手段は決めてないので、何もしない。
    }
}
