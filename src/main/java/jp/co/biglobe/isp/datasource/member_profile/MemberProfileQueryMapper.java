package jp.co.biglobe.isp.datasource.member_profile;

import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileEntity;
import org.apache.ibatis.annotations.Param;

public interface MemberProfileQueryMapper {

    public void profileRegister(
            @Param("memberProfileEntity") MemberProfileEntity memberProfileEntity
    );

    public void mailAddressRegister(
            @Param("memberProfileEntity") MemberProfileEntity memberProfileEntity
    );
}
