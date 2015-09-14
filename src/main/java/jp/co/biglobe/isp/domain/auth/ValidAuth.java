package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ValidAuth implements Auth{

    @Getter
    private final UserId userId;

    private final UserPassword userPassword;


    @Override
    public boolean 存在するか(){
        return true;
    }

    @Override
    public boolean 認証OKか(MemberEntity memberEntity){
        return memberEntity.入会中か();
    }
}
