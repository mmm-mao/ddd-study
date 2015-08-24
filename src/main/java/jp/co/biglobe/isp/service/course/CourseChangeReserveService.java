package jp.co.biglobe.isp.service.course;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.service.auth.BiglobeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseChangeReserveService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BiglobeAuthService biglobeAuthService;

    public void 受け付ける(ValidAuth validAuth, ChangeReserveCourse changeReserveCourse){


        検証する(validAuth, changeReserveCourse);

        コース変更予約する(validAuth.getBiglobeId(), changeReserveCourse);


    }

    private void 検証する(ValidAuth validAuth, ChangeReserveCourse changeReserveCourse){

        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

        MemberEntity memberEntity = memberRepository.BiglobeIdで検索する(validAuth.getBiglobeId());

        Course course = courseRepository.BiglobeIdで検索する(validAuth.getBiglobeId());

        if(course.コース変更予約できるか(memberEntity, changeReserveCourse)){
            return;
        }

        throw new RuntimeException("コース変更できない");


    }


    private void コース変更予約する(BiglobeId biglobeId, ChangeReserveCourse changeReserveCourse){

        Course course = courseRepository.BiglobeIdで検索する(biglobeId);
        courseRepository.変更予約する(course.コース変更予約する(changeReserveCourse));
    }


}
