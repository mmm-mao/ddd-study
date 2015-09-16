package jp.co.biglobe.isp.domain.member;

import jp.co.biglobe.isp.domain.member.member_life_cycle.MemberLifeCycle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member {

    private final BiglobeId biglobeId;

    private final MemberLifeCycle lifeCycle;

    /**
     * 以下、エンティティのcreateのメソッド群
     */
    public static Member 入会する(BiglobeId biglobeId){
        return new Member(biglobeId, MemberLifeCycle.入会する());
    }

    public Member 退会する(){
        return new Member(biglobeId, lifeCycle.退会する());
    }


    /**
     * 以下、エンティティのcreate以外の業務ロジックのメソッド群
     */
    public boolean is入会中(){
        return lifeCycle.is入会中();
    }

    public boolean is退会できる(){
        return lifeCycle.is退会できる();
    }

}
