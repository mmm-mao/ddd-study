package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.Member;

public interface Auth {


    public boolean is認証OK(Member member);
}
