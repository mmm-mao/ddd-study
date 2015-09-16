package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.Member;
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


    /**
     * 以下、エンティティのcreate以外の業務ロジックのメソッド群
     */

    @Override
    public boolean is認証OK(Member member){
        return member.is入会中();
    }
}
