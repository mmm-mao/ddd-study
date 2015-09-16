package jp.co.biglobe.isp.domain.course.change_reserve;

import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ChangeReserveCourse {

    @Getter
    private final CourseName courseName;

    public CurrentCourse toCurrentCourse(){
        return new CurrentCourse(courseName);
    }

    public boolean is変更を申し込むコースが適用中のコースと同じ(CurrentCourse currentCourse){
        return courseName.is同じコース(currentCourse.getCourseName());
    }
    
}
