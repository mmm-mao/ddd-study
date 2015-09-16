package jp.co.biglobe.isp.domain.credit_card;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@AllArgsConstructor
public enum ValidCreditCardStatus {
    有効,
    無効;

    public static ValidCreditCardStatus 作成する(boolean checkResult){
        if(checkResult){
            return ValidCreditCardStatus.有効;
        }

        return ValidCreditCardStatus.無効;
    }

    public boolean 無効か(){
        return this.equals(ValidCreditCardStatus.無効);
    }

    public CreditCardRegisterStatus 無効から有効に戻せるか(){


        if(今現在有効か()){
            return CreditCardRegisterStatus.登録不可;
        }

        return CreditCardRegisterStatus.登録可能;

    }

    private boolean 今現在有効か(){
        return this.equals(ValidCreditCardStatus.有効);
    }
}
