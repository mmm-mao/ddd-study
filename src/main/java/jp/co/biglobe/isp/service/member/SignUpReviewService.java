package jp.co.biglobe.isp.service.member;

import jp.co.biglobe.isp.domain.credit_card.CreditCardRegisterStatus;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.sign_up_review.RealTimeReview;
import jp.co.biglobe.isp.service.credit_card.CreditCardCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpReviewService {

    @Autowired
    private CreditCardCheckService creditCardCheckService;

    public void 検証する(SignUpRequest signUpRequest){

        CreditCardRegisterStatus creditCardRegisterStatus = creditCardCheckService.受け付ける(signUpRequest.getCreditCard());

        RealTimeReview realTimeReview = new RealTimeReview(creditCardRegisterStatus, signUpRequest.getProfile());
        realTimeReview.検証する();

    }

}
