package jp.co.biglobe.isp.datasource.course;


import jp.co.biglobe.isp.domain.course.*;
import jp.co.biglobe.isp.domain.course.change_reserve.ValidCourseChangeReserve;
import jp.co.biglobe.isp.domain.member.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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
    public Course BiglobeIdで検索する_存在しなかったらエラー(UserId userId){

        List<ValidCourseChangeReserve> list = courseQueryMapper.findByUserId(userId);

        if(is存在しない(list)){
            throw new UnsupportedOperationException("コースが存在しない");

        }

        if(is過去にコース変更予約していない(list)){
            return Course.作成する(userId, list.get(0).toCurrentCourse());
        }

        CourseFactory courseFactory = new CourseFactory(userId, list.get(0), list.get(1));
        return courseFactory.createCourse();
    }

    private boolean is存在しない(List<ValidCourseChangeReserve> list){
        return list.size() == 0;
    }

    private boolean is過去にコース変更予約していない(List<ValidCourseChangeReserve> list){
        return list.size() == 1;
    }
}
