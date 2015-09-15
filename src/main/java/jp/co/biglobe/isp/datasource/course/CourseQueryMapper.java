package jp.co.biglobe.isp.datasource.course;

import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.UserId;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface CourseQueryMapper {

    public void register(
            @Param("course") Course course,
            @Param("today") LocalDate today
    );

    public List<ValidCourseChangeReserve> findByUserId(
            @Param("userId") UserId userId
    );

}
