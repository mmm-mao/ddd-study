package jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class SignUpDate {

    private final LocalDate value;

    public static SignUpDate 作成する(){
        return new SignUpDate(LocalDate.now());
    }

}
