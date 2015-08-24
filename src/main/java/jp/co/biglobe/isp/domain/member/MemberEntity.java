package jp.co.biglobe.isp.domain.member;

import jp.co.biglobe.isp.domain.member.member_life_cycle.MemberLifeCycle;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.isp.domain.member_profile.MailAddress;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberEntity {

    private final BiglobeId biglobeId;

    private final MemberLifeCycle memberLifeCycle;

    public static MemberEntity 入会する(BiglobeId biglobeId){
        return new MemberEntity(biglobeId, MemberLifeCycle.入会する());
    }

    public MemberEntity 退会する(){
        return new MemberEntity(biglobeId, memberLifeCycle.退会する());
    }


    public boolean 入会中か(){
        return memberLifeCycle.入会中か();
    }

    public boolean 退会できるか(){
        return memberLifeCycle.退会できるか();
    }

}
