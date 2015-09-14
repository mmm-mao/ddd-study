package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.MemberEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistAuth implements Auth{


    @Override
    public boolean 存在するか(){
        return false;
    }

    @Override
    public boolean 認証OKか(MemberEntity memberEntity){
        return false;
    }
}
