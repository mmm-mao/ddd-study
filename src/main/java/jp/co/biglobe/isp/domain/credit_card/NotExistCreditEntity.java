package jp.co.biglobe.isp.domain.credit_card;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistCreditEntity implements CreditEntity {

    @Override
    public boolean exist(){
        return false;
    }

    @Override
    public CreditCardRegisterStatus 変更できるか(ValidCreditCardStatus validCreditCardStatus){
        if(validCreditCardStatus.無効か()){
            return CreditCardRegisterStatus.登録不可;
        }

        return CreditCardRegisterStatus.登録可能;
    }

    @Override
    public CreditCardRegisterStatus 無効から有効に戻せるか(ValidCreditCardStatus validCreditCardStatus, BiglobeId biglobeId){
        return CreditCardRegisterStatus.登録不可;
    }
}
