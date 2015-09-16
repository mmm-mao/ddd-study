package jp.co.biglobe.isp.datasource.course;

import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface CourseQueryMapper {

    public void register(
            @Param("course") Course course,
            @Param("today") LocalDate today
    );

    public void change(
            @Param("course") Course course
    );


    public List<ValidCourseChangeReserve> findByBiglobeId(
            @Param("biglobeId") BiglobeId biglobeId
    );

}
