package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class ValidAuth implements Auth{

    @Getter
    private final UserId userId;

    private final UserPassword userPassword;


    @Override
    public boolean 認証OKか(MemberEntity memberEntity){
        return memberEntity.入会中か();
    }
}
