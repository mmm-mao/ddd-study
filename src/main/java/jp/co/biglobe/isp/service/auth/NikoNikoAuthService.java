package jp.co.biglobe.isp.service.auth;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.member.Member;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NikoNikoAuthService {

    @Autowired
    private BiglobeAuthService biglobeAuthService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;


    public void 受け付ける(ValidAuth validAuth){


        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

        Member member = memberRepository.biglobeIdで検索する_存在しなかったらエラー(validAuth.getBiglobeId());

        Course course = courseRepository.biglobeIdで検索する_存在しなかったらエラー(validAuth.getBiglobeId());


        if(course.isニコニコ動画認証OK(member)){
            return;
        }

        throw new UnsupportedOperationException("ニコニコ動画認証できません");




    }

}
