package jp.co.biglobe.isp.domain.credit_card;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistCredit implements Credit {

    @Override
    public boolean exist(){
        return false;
    }

    @Override
    public CreditCardRegisterStatus is変更できる(ValidCreditCardStatus validCreditCardStatus){
        if(validCreditCardStatus.is無効()){
            return CreditCardRegisterStatus.登録不可;
        }

        return CreditCardRegisterStatus.登録可能;
    }

    @Override
    public CreditCardRegisterStatus 無効から有効に戻せるか(ValidCreditCardStatus validCreditCardStatus, BiglobeId biglobeId){
        return CreditCardRegisterStatus.登録不可;
    }
}
