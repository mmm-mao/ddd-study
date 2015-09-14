package jp.co.biglobe.isp.domain.course;

import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.course.change_reserve.CourseChangeReserve;
import jp.co.biglobe.isp.domain.course.change_reserve.NotExistCourseChangeReserve;
import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Course {

    private final UserId userId;

    private final CurrentCourse currentCourse;

    private final CourseChangeReserve courseChangeReserve;

    public static Course 作成する(UserId userId, CurrentCourse currentCourse){
        return new Course(userId, currentCourse, new NotExistCourseChangeReserve());
    }


    public Course コース変更予約する(ChangeReserveCourse changeReserveCourse){
        return new Course(userId, currentCourse, ValidCourseChangeReserve.作成する(changeReserveCourse));
    }

    public boolean コース変更予約できるか(MemberEntity memberEntity, ChangeReserveCourse changeReserveCourse) {

        if (!memberEntity.入会中か()) {
            return false;
        }

        if (currentCourse.変更を申し込むコースが適用中のコースと同じか(changeReserveCourse)) {
            return false;
        }

        if (courseChangeReserve.コース変更を申し込み中か()) {
            return false;
        }

        return true;
    }

    public boolean ニコニコ動画認証OKか(MemberEntity memberEntity){

        if(!currentCourse.ニコニココースか()){
            return false;
        }

        if(!memberEntity.入会中か()){
            return false;
        }

        return true;


    }
}

