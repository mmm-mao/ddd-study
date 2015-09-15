package jp.co.biglobe.isp.service.course;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
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

        コース変更予約する(validAuth.getUserId(), changeReserveCourse);

    }

    private void コース変更予約する(UserId userId, ChangeReserveCourse changeReserveCourse){

        Course course = courseRepository.BiglobeIdで検索する_存在しなかったらエラー(userId);
        courseRepository.変更予約する(course.コース変更予約する(changeReserveCourse));
    }


}
