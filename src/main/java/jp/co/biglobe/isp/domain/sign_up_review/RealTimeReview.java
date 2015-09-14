package jp.co.biglobe.isp.domain.sign_up_review;

import jp.co.biglobe.isp.domain.credit_card.CreditCardRegisterStatus;
import jp.co.biglobe.isp.domain.member_profile.profile.Profile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RealTimeReview {

    private final CreditCardRegisterStatus creditCardRegisterStatus;

    private final Profile profile;

    public void 検証する(){

        if(!creditCardRegisterStatus.登録できるか()){
            throw new UnsupportedOperationException("クレジットカードが無効");
        }

        if(profile._20歳未満か()){
            throw new UnsupportedOperationException("20歳未満");
        }

        return;
        

    }

}
