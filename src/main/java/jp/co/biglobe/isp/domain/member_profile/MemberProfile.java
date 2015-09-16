package jp.co.biglobe.isp.domain.member_profile;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.member_profile.profile.Profile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberProfile {

    private final BiglobeId biglobeId;

    private final Profile profile;

    private final MailAddress mailAddress;

    public static MemberProfile 登録する(BiglobeId biglobeId, SignUpRequest signUpRequest){
        return new MemberProfile(biglobeId, signUpRequest.getProfile(), signUpRequest.getHopeMailAddress().メールアドレスに変換する());
    }

}
