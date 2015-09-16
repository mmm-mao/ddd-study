package jp.co.biglobe.isp.domain.credit_card;


import jp.co.biglobe.isp.domain.member.BiglobeId;

public interface CreditEntity {

    public boolean exist();

    public CreditCardRegisterStatus 変更できるか(ValidCreditCardStatus validCreditCardStatus);

    public CreditCardRegisterStatus 無効から有効に戻せるか(ValidCreditCardStatus validCreditCardStatus, BiglobeId biglobeId);
}
