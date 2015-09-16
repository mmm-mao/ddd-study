package jp.co.biglobe.isp.domain.credit_card;


import jp.co.biglobe.isp.domain.member.BiglobeId;

public interface Credit {

    public boolean exist();

    public CreditCardRegisterStatus is変更できる(ValidCreditCardStatus validCreditCardStatus);

    public CreditCardRegisterStatus 無効から有効に戻せるか(ValidCreditCardStatus validCreditCardStatus, BiglobeId biglobeId);
}
