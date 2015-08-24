package jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up;

import jp.co.biglobe.isp.domain.member_profile.MailAddress;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HopeMailAddress {

    private final String value;

    public MailAddress メールアドレスに変換する(){
        return new MailAddress(value);
    }

}
