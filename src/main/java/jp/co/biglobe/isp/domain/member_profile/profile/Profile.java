package jp.co.biglobe.isp.domain.member_profile.profile;

import jp.co.biglobe.isp.domain.member_profile.profile.address.Address;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.PhoneNumber;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Profile {

    private final Name name;

    private final NameKana nameKana;

    private final Gender gender;

    private final Birthday birthday;

    private final Address address;

    private final PhoneNumber phoneNumber;

    public boolean _20歳未満か(){
        return birthday._20歳未満か();
    }

}
