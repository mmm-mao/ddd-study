package jp.co.biglobe.isp.domain.credit_card;


public enum CreditCardRegisterStatus {
    登録可能,
    登録不可;

    public boolean is登録できる(){
        return this.equals(CreditCardRegisterStatus.登録可能);
    }


}
