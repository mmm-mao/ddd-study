package jp.co.biglobe.isp.domain.course.change_reserve;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;

@AllArgsConstructor
public class CourseSwitchingDate {

    private final LocalDate value;

    public static CourseSwitchingDate 翌月1日で作成する(){
        return new CourseSwitchingDate(YearMonth.now().plusMonths(1).atDay(1));
    }


    boolean is過去日(){
        return value.isBefore(LocalDate.now());
    }

}
