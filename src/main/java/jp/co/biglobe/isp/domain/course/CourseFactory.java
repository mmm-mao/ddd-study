package jp.co.biglobe.isp.domain.course;

import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseFactory {

    private final BiglobeId biglobeId;

    private final ValidCourseChangeReserve latest;

    private final ValidCourseChangeReserve oneBefore;

    public Course createCourse(){

        if(latest.isコース変更を申し込み中()){
            return new Course(biglobeId, oneBefore.toCurrentCourse(), latest);
        }

        return Course.作成する(biglobeId, latest.toCurrentCourse());


    }


}
