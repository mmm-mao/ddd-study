package jp.co.biglobe.isp.domain.member_profile.profile;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Birthday {

    private final LocalDate value;

    public boolean _20歳未満か(){
        return false;
    }

}
