package jp.co.biglobe.isp.domain.course;

import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.course.change_reserve.CourseChangeReserve;
import jp.co.biglobe.isp.domain.course.change_reserve.NotExistCourseChangeReserve;
import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Course {

    private final BiglobeId biglobeId;

    private final CurrentCourse currentCourse;

    private final CourseChangeReserve courseChangeReserve;

    /**
     * 以下、エンティティのcreateのメソッド群
     */
    public static Course 作成する(BiglobeId biglobeId, CurrentCourse currentCourse){
        return new Course(biglobeId, currentCourse, new NotExistCourseChangeReserve());
    }


    public Course コース変更予約する(ChangeReserveCourse changeReserveCourse){
        return new Course(biglobeId, currentCourse, ValidCourseChangeReserve.作成する(changeReserveCourse));
    }

    /**
     * 以下、エンティティのcreate以外の業務ロジックのメソッド群
     */

    public boolean isコース変更予約できる(Member member, ChangeReserveCourse changeReserveCourse) {

        if (!member.is入会中()) {
            return false;
        }

        if(changeReserveCourse.is変更を申し込むコースが適用中のコースと同じ(currentCourse)){
            return false;
        }

        if (courseChangeReserve.isコース変更を申し込み中()) {
            return false;
        }

        return true;
    }

    public boolean isニコニコ動画認証OK(Member member){

        if(!currentCourse.isニコニココース()){
            return false;
        }

        if(!member.is入会中()){
            return false;
        }

        return true;


    }
}

