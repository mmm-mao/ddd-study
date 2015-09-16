package jp.co.biglobe.isp.domain.credit_card;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class ValidCreditEntity implements CreditEntity {

    @Getter
    private final CreditCardNumber creditCardNumber;

    @Getter
    private final BiglobeId biglobeId;

    private final ValidCreditCardStatus validCreditCardStatus;

    public static ValidCreditEntity 作成する(CreditCardNumber creditCardNumber, BiglobeId biglobeId){
        return new ValidCreditEntity(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }

    public ValidCreditEntity 無効にする(){
        return new ValidCreditEntity(creditCardNumber, biglobeId, ValidCreditCardStatus.無効);
    }

    @Override
    public boolean exist(){
        return true;
    }

    @Override
    public CreditCardRegisterStatus 変更できるか(ValidCreditCardStatus validCreditCardStatus){
        return CreditCardRegisterStatus.登録不可;
    }

    public boolean 無効か(){
        return validCreditCardStatus.無効か();
    }

    public ValidCreditEntity 有効に戻す(CreditCardNumber creditCardNumber){
        return new ValidCreditEntity(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }

    public ValidCreditEntity 変更する(CreditCardNumber creditCardNumber){
        return new ValidCreditEntity(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }
}

