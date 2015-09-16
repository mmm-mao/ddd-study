package jp.co.biglobe.isp.datasource.member_profile;

import jp.co.biglobe.isp.domain.member_profile.MemberProfile;
import org.apache.ibatis.annotations.Param;

public interface MemberProfileQueryMapper {

    public void profileRegister(
            @Param("memberProfileEntity") MemberProfile memberProfile
    );

    public void mailAddressRegister(
            @Param("memberProfileEntity") MemberProfile memberProfile
    );
}
