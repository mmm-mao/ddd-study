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
    
}
