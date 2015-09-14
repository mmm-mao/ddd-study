package jp.co.biglobe.isp.datasource.course;


import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.member.UserId;
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
    public Course BiglobeIdで検索する(UserId userId){
        return Course.作成する(userId, new CurrentCourse(CourseName.ベーシック));
    }
}
