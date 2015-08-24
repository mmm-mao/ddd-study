package jp.co.biglobe.isp.domain.auth;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditCardStatus;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ValidAuth implements Auth{

    @Getter
    private final BiglobeId biglobeId;

    private final BiglobePassword biglobePassword;


    @Override
    public boolean 存在するか(){
        return true;
    }

    @Override
    public boolean 認証OKか(MemberEntity memberEntity){
        return memberEntity.入会中か();
    }
}
