package jp.co.biglobe.isp.domain.member_profile.profile;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Birthday {

    private final LocalDate value;

    public boolean is20歳未満(){
        if(年齢を計算する() < 20){
            return true;
        };

        return false;
    }

    private int 年齢を計算する(){
        return DateUtil.指定された年月日から経過年数を計算する(value);
    }

}
