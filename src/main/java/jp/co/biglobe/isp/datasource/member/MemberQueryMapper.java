package jp.co.biglobe.isp.datasource.member;

import jp.co.biglobe.isp.domain.member.Member;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.apache.ibatis.annotations.Param;

public interface MemberQueryMapper {

    public void signUp(
            @Param("memberEntity") Member member
    );

    public void withdrawal(
            @Param("memberEntity") Member member
    );


    public Member findByBiglobeId(
            @Param("biglobeId") BiglobeId biglobeId
    );
}
