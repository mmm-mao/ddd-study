package jp.co.biglobe.isp.domain.sign_up_review;

import jp.co.biglobe.isp.domain.credit_card.CreditCardRegisterStatus;
import jp.co.biglobe.isp.domain.member_profile.profile.Profile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RealTimeReview {

    private final CreditCardRegisterStatus creditCardRegisterStatus;

    private final Profile profile;

    public void 検証する(){

        if(!creditCardRegisterStatus.is登録できる()){
            throw new UnsupportedOperationException("クレジットカードが無効");
        }

        if(profile.is20歳未満()){
            throw new UnsupportedOperationException("20歳未満");
        }

        return;
        

    }

}
