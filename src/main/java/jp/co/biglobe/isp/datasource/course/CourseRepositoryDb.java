package jp.co.biglobe.isp.datasource.course;


import jp.co.biglobe.isp.domain.course.Course;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CourseRepository;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.member.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class CourseRepositoryDb implements CourseRepository {

    @Autowired
    private CourseQueryMapper courseQueryMapper;


    @Override
    public void 登録する(Course course){
        courseQueryMapper.register(course, LocalDate.now());
    }

    @Override
    public void 変更予約する(Course course){

    }

    @Override
    public Course BiglobeIdで検索する(UserId userId){
        return Course.作成する(userId, new CurrentCourse(CourseName.ベーシック));
    }
}
