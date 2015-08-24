package jp.co.biglobe.isp.domain.credit_card;

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

}
