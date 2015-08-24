package jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

@AllArgsConstructor
public class WithdrawalDate {

    private final LocalDate value;

    public static WithdrawalDate 月末日で作成する(){
        return new WithdrawalDate(YearMonth.now().atEndOfMonth());
    }

    boolean 過去日か(){
        return value.isBefore(LocalDate.now());
    }

}
