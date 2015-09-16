package jp.co.biglobe.isp.domain.course.change_reserve;

import jp.co.biglobe.isp.domain.course.CurrentCourse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidCourseChangeReserve implements CourseChangeReserve{

    private final ChangeReserveCourse changeReserveCourse;

    private final CourseSwitchingDate courseSwitchingDate;

    public static ValidCourseChangeReserve 作成する(ChangeReserveCourse changeReserveCourse){
        return new ValidCourseChangeReserve(changeReserveCourse, CourseSwitchingDate.翌月1日で作成する());
    }

    @Override
    public boolean isコース変更を申し込み中(){

        if(courseSwitchingDate.is過去日()){
            return false;
        }

        return true;
    }

    public CurrentCourse toCurrentCourse(){
        return changeReserveCourse.toCurrentCourse();
    }
}
