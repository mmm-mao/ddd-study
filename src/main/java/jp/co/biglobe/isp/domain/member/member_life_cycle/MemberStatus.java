package jp.co.biglobe.isp.domain.member.member_life_cycle;


public enum MemberStatus {
    入会中,
    退会予約中,
    退会済み;


    public boolean is入会中(){
        return this.equals(MemberStatus.入会中) || this.equals(MemberStatus.退会予約中);
    }

}
