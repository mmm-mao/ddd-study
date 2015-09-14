package jp.co.biglobe.isp.datasource.member;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditEntity;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberQueryMapper {

    public void signUp(
            @Param("memberEntity") MemberEntity memberEntity
    );
}
