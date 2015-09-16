package jp.co.biglobe.isp.domain.credit_card;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class ValidCredit implements Credit {

    @Getter
    private final CreditCardNumber creditCardNumber;

    @Getter
    private final BiglobeId biglobeId;

    private final ValidCreditCardStatus validCreditCardStatus;

    public static ValidCredit 作成する(CreditCardNumber creditCardNumber, BiglobeId biglobeId){
        return new ValidCredit(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }

    public ValidCredit 無効にする(){
        return new ValidCredit(creditCardNumber, biglobeId, ValidCreditCardStatus.無効);
    }

    public ValidCredit 有効に戻す(){
        return new ValidCredit(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }

    public ValidCredit 変更する(CreditCardNumber creditCardNumber){
        return new ValidCredit(creditCardNumber, biglobeId, ValidCreditCardStatus.有効);
    }

    @Override
    public boolean exist(){
        return true;
    }

    @Override
    public CreditCardRegisterStatus is変更できる(ValidCreditCardStatus validCreditCardStatus){
        return 既に同一クレジットカードが申し込み中のため登録不可();
    }

    private CreditCardRegisterStatus 既に同一クレジットカードが申し込み中のため登録不可(){
        return CreditCardRegisterStatus.登録不可;
    }

    @Override
    public CreditCardRegisterStatus 無効から有効に戻せるか(ValidCreditCardStatus validCreditCardStatus, BiglobeId biglobeId){

        if(!this.biglobeId.is同一ID(biglobeId)){
            return CreditCardRegisterStatus.登録不可;
        }

        if(validCreditCardStatus.is無効()){
            return CreditCardRegisterStatus.登録不可;
        }

        return this.validCreditCardStatus.is無効から有効に戻せる();
    }

    public boolean is無効(){
        return validCreditCardStatus.is無効();
    }


}

