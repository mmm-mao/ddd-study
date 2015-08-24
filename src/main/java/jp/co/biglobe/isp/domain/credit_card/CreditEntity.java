package jp.co.biglobe.isp.domain.credit_card;


public interface CreditEntity {

    public boolean exist();

    public CreditCardRegisterStatus 変更できるか(ValidCreditCardStatus validCreditCardStatus);
}
