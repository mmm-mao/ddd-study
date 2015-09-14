package jp.co.biglobe.isp.service.member;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.auth.AuthRepository;
import jp.co.biglobe.isp.domain.auth.UserPassword;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.UserId;
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

        UserId userId = memberRepository.識別子を作成する();

        入会する(userId);

        プロフィールを登録する(userId, signUpRequest);

        クレジットカードを登録する(userId, signUpRequest);

        コースを登録する(userId, signUpRequest);

        return 認証を登録する(userId);

    }

    private void 入会する(UserId userId){
        MemberEntity memberEntity = MemberEntity.入会する(userId);
        memberRepository.入会する(memberEntity);
    }

    private void プロフィールを登録する(UserId userId, SignUpRequest signUpRequest){
        MemberProfileEntity memberProfileEntity = MemberProfileEntity.登録する(userId, signUpRequest);
        memberProfileRepository.登録する(memberProfileEntity);
    }

    private void クレジットカードを登録する(UserId userId, SignUpRequest signUpRequest){
        ValidCreditEntity validCreditCardEntity = ValidCreditEntity.作成する(signUpRequest.getCreditCardNumber(), userId);
        creditCardRepository.登録する(validCreditCardEntity);
    }

    private void コースを登録する(UserId userId, SignUpRequest signUpRequest){
        Course course = Course.作成する(userId, signUpRequest.getCurrentCourse());
        courseRepository.登録する(course);
    }

    private ValidAuth 認証を登録する(UserId userId){
        UserPassword userPassword = authRepository.パスワードを作成する();
        ValidAuth validAuth = new ValidAuth(userId, userPassword);
        authRepository.登録する(validAuth);
        return validAuth;
    }




}
