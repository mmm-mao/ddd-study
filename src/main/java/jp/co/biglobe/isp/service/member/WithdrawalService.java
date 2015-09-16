package jp.co.biglobe.isp.service.member;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.service.auth.BiglobeAuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    @Autowired
    private BiglobeAuthService biglobeAuthService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;


    public WithdrawalConfirmContainer 確認する(ValidAuth validAuth){

        biglobeAuthService.サービス利用不可をOKとして認証する(validAuth);

        MemberEntity memberEntity = memberRepository.BiglobeIdで検索する_存在しなかったらエラー(validAuth.getUserId());

        Course course = courseRepository.BiglobeIdで検索する_存在しなかったらエラー(validAuth.getUserId());

        return new WithdrawalConfirmContainer(memberEntity, course);
    }

    @AllArgsConstructor
    public class WithdrawalConfirmContainer{
        private final MemberEntity memberEntity;

        private final Course course;
    }

    public void 受け付ける(ValidAuth validAuth){

        検証する(validAuth);

        退会する(validAuth.getUserId());

    }

    private void 検証する(ValidAuth validAuth){

        biglobeAuthService.サービス利用不可をOKとして認証する(validAuth);

        MemberEntity memberEntity = memberRepository.BiglobeIdで検索する_存在しなかったらエラー(validAuth.getUserId());

        if(!memberEntity.退会できるか()){
            throw new RuntimeException("既に退会申し込み済みです");
        }
    }

    private void 退会する(UserId userId){
        MemberEntity memberEntity = memberRepository.BiglobeIdで検索する_存在しなかったらエラー(userId);
        memberRepository.退会する(memberEntity.退会する());
    }


}
