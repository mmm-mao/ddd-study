package jp.co.biglobe.isp.domain.course.change_reserve;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;

@AllArgsConstructor
public class CourseSwitchingDate {

    private final LocalDate value;

    public static CourseSwitchingDate 月末日で作成する(){
        return new CourseSwitchingDate(YearMonth.now().atEndOfMonth());
    }


    boolean 過去日か(){
        return value.isBefore(LocalDate.now());
    }

}
