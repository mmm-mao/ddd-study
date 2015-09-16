package jp.co.biglobe.isp.service.course;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.Member;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.service.auth.BiglobeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseChangeReserveCheckService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BiglobeAuthService biglobeAuthService;


    public void 検証する(ValidAuth validAuth, ChangeReserveCourse changeReserveCourse){

        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

        Member member = memberRepository.biglobeIdで検索する_存在しなかったらエラー(validAuth.getBiglobeId());

        Course course = courseRepository.biglobeIdで検索する_存在しなかったらエラー(validAuth.getBiglobeId());

        if(course.isコース変更予約できる(member, changeReserveCourse)){
            return;
        }

        throw new UnsupportedOperationException("コース変更できない");


    }

}
