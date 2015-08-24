package jp.co.biglobe.isp.domain.course.change_reserve;

import lombok.AllArgsConstructor;

public class NotExistCourseChangeReserve implements CourseChangeReserve{


    @Override
    public boolean コース変更を申し込み中か(){
        return false;
    }
}
