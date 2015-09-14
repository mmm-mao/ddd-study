package jp.co.biglobe.isp.domain.member;

import jp.co.biglobe.isp.domain.member.member_life_cycle.MemberLifeCycle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberEntity {

    private final UserId userId;

    private final MemberLifeCycle memberLifeCycle;

    public static MemberEntity 入会する(UserId userId){
        return new MemberEntity(userId, MemberLifeCycle.入会する());
    }

    public MemberEntity 退会する(){
        return new MemberEntity(userId, memberLifeCycle.退会する());
    }


    public boolean 入会中か(){
        return memberLifeCycle.入会中か();
    }

    public boolean 退会できるか(){
        return memberLifeCycle.退会できるか();
    }

}
