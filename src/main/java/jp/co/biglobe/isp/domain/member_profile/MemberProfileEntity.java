package jp.co.biglobe.isp.domain.member_profile;

import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.member_profile.profile.Profile;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberProfileEntity {

    private final UserId userId;

    private final Profile profile;

    private final MailAddress mailAddress;

    public static MemberProfileEntity 登録する(UserId userId, SignUpRequest signUpRequest){
        return new MemberProfileEntity(userId, signUpRequest.getProfile(), signUpRequest.getHopeMailAddress().メールアドレスに変換する());
    }

}
