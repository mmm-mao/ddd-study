package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.BiglobeId;
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
    private final BiglobeId biglobeId;

    private final Password password;


    @Override
    public boolean 認証OKか(MemberEntity memberEntity){
        return memberEntity.入会中か();
    }
}
