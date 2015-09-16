package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.MemberEntity;

public interface Auth {


    public boolean 認証OKか(MemberEntity memberEntity);
}
