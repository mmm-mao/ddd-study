package jp.co.biglobe.isp.domain.member_profile.profile;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateUtil {

    public static int 指定された年月日から経過年数を計算する(LocalDate targetDate) {

        LocalDate today = LocalDate.now();

        return getElapsedYears(targetDate, today);

    }

    private static int getElapsedYears(LocalDate targetDate, LocalDate today) {
        return Period.between(targetDate, today).getYears();
    }
}
