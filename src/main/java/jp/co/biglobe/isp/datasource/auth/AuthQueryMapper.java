package jp.co.biglobe.isp.datasource.auth;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.Course;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

public interface AuthQueryMapper {

    public void register(
            @Param("validAuth") ValidAuth validAuth
    );


}
