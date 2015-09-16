package jp.co.biglobe.isp.datasource.member;

import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.apache.ibatis.annotations.Param;

public interface MemberQueryMapper {

    public void signUp(
            @Param("memberEntity") MemberEntity memberEntity
    );

    public void withdrawal(
            @Param("memberEntity") MemberEntity memberEntity
    );


    public MemberEntity findByBiglobeId(
            @Param("biglobeId") BiglobeId biglobeId
    );
}
