package jp.co.biglobe.isp.domain.credit_card;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class EffectiveMonth {

    //@Getter
    private final YearMonth value;

    public String get有効かチェックする値(){
        return value.format(DateTimeFormatter.ofPattern("uuuuMM"));
    }

}
