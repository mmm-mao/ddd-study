package jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up;


import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.credit_card.CreditCard;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.member_profile.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SignUpRequest {

    @Getter
    private final Profile profile;

    @Getter
    private final CreditCard creditCard;

    @Getter
    private final CurrentCourse currentCourse;

    @Getter
    private final HopeMailAddress hopeMailAddress;


    public CreditCardNumber getCreditCardNumber(){
        return creditCard.getCreditCardNumber();
    }
}
