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
}
