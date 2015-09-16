package jp.co.biglobe.isp.service.course;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.service.auth.BiglobeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseChangeReserveService {

    @Autowired
    private CourseChangeReserveCheckService courseChangeReserveCheckService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BiglobeAuthService biglobeAuthService;

    public void 受け付ける(ValidAuth validAuth, ChangeReserveCourse changeReserveCourse){

        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

        コース変更予約する(validAuth.getBiglobeId(), changeReserveCourse);

    }

    private void コース変更予約する(BiglobeId biglobeId, ChangeReserveCourse changeReserveCourse){

        Course course = courseRepository.biglobeIdで検索する_存在しなかったらエラー(biglobeId);
        courseRepository.変更予約する(course.コース変更予約する(changeReserveCourse));
    }


}
