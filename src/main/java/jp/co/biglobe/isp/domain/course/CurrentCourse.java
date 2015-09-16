package jp.co.biglobe.isp.domain.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CurrentCourse {

    @Getter
    private final CourseName courseName;

    public boolean isニコニココース(){
        return courseName.ニコニココースか();
    }
    
}
