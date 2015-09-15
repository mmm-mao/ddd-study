package jp.co.biglobe.isp.domain.course;

import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.UserId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseFactory {

    private final UserId userId;

    private final ValidCourseChangeReserve latest;

    private final ValidCourseChangeReserve oneBefore;

    public Course createCourse(){

        if(latest.コース変更を申し込み中か()){
            return new Course(userId, oneBefore.toCurrentCourse(), latest);
        }

        return Course.作成する(userId, latest.toCurrentCourse());


    }


}
