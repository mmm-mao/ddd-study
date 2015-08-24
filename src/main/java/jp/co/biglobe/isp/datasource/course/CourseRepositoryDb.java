package jp.co.biglobe.isp.datasource.course;


import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.outsource.domain.クレジットカードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryDb implements CourseRepository {

    @Override
    public void 登録する(Course course){

    }

    @Override
    public void 変更予約する(Course course){

    }

    @Override
    public Course BiglobeIdで検索する(BiglobeId biglobeId){
        return Course.作成する(biglobeId, new CurrentCourse(CourseName.ベーシック));
    }
}
