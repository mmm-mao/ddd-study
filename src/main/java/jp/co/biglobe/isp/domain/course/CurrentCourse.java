package jp.co.biglobe.isp.domain.course;

import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrentCourse {

    private final CourseName courseName;

    public boolean 変更を申し込むコースが適用中のコースと同じか(ChangeReserveCourse changeReserveCourse){
        return courseName.equals(changeReserveCourse.getCourseName());
    }

    public boolean ニコニココースか(){
        return courseName.ニコニココースか();
    }
    
}
