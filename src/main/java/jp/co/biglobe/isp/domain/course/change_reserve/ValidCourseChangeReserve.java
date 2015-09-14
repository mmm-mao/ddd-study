package jp.co.biglobe.isp.domain.course.change_reserve;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidCourseChangeReserve implements CourseChangeReserve{

    private final ChangeReserveCourse changeReserveCourse;

    private final CourseSwitchingDate courseSwitchingDate;

    public static ValidCourseChangeReserve 作成する(ChangeReserveCourse changeReserveCourse){
        return new ValidCourseChangeReserve(changeReserveCourse, CourseSwitchingDate.月末日で作成する());
    }

    @Override
    public boolean コース変更を申し込み中か(){

        if(courseSwitchingDate.過去日か()){
            return false;
        }

        return true;
    }
}
