package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistAuth implements Auth{


    @Override
    public boolean is認証OK(Member member){
        return false;
    }
}
