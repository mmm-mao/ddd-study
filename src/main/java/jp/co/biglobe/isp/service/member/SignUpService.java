package jp.co.biglobe.isp.service.member;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.auth.AuthRepository;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileEntity;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private SignUpReviewService signUpReviewService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberProfileRepository memberProfileRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthRepository authRepository;

    public ValidAuth 受け付ける(SignUpRequest signUpRequest){

        signUpReviewService.検証する(signUpRequest);

        BiglobeId biglobeId = memberRepository.識別子を作成する();

        入会する(biglobeId);

        プロフィールを登録する(biglobeId, signUpRequest);

        クレジットカードを登録する(biglobeId, signUpRequest);

        コースを登録する(biglobeId, signUpRequest);

        return 認証を登録する(biglobeId);

    }

    private void 入会する(BiglobeId biglobeId){
        MemberEntity memberEntity = MemberEntity.入会する(biglobeId);
        memberRepository.入会する(memberEntity);
    }

    private void プロフィールを登録する(BiglobeId biglobeId, SignUpRequest signUpRequest){
        MemberProfileEntity memberProfileEntity = MemberProfileEntity.登録する(biglobeId, signUpRequest);
        memberProfileRepository.登録する(memberProfileEntity);
    }

    private void クレジットカードを登録する(BiglobeId biglobeId, SignUpRequest signUpRequest){
        ValidCreditEntity validCreditCardEntity = ValidCreditEntity.作成する(signUpRequest.getCreditCardNumber(), biglobeId);
        creditCardRepository.登録する(validCreditCardEntity);
    }

    private void コースを登録する(BiglobeId biglobeId, SignUpRequest signUpRequest){
        Course course = Course.作成する(biglobeId, signUpRequest.getCurrentCourse());
        courseRepository.登録する(course);
    }

    private ValidAuth 認証を登録する(BiglobeId biglobeId){
        Password password = authRepository.パスワードを作成する();
        ValidAuth validAuth = new ValidAuth(biglobeId, password);
        authRepository.登録する(validAuth);
        return validAuth;
    }




}
