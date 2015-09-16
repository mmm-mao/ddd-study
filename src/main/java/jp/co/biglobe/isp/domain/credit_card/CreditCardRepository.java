package jp.co.biglobe.isp.domain.credit_card;


import jp.co.biglobe.isp.domain.member.BiglobeId;

public interface CreditCardRepository {

    public CreditEntity クレジットカード番号で検索する(CreditCardNumber creditCardNumber);

    public ValidCreditEntity クレジットカード番号で検索する_存在しなかったらエラー(CreditCardNumber creditCardNumber);

    public ValidCreditEntity biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId);

    public ValidCreditCardStatus 有効かチェックする(CreditCard creditCard);

    public void 登録する(ValidCreditEntity validCreditCardEntity);

    public void 無効にする(ValidCreditEntity validCreditCardEntity);

    public void 有効に戻す(ValidCreditEntity validCreditCardEntity);

    public void 変更する(ValidCreditEntity validCreditCardEntity);

    public void 送付されてきたクレジットカード情報が無効だと通知する(BiglobeId biglobeId);

    public void 無効になったことを通知する(BiglobeId biglobeId);


}
