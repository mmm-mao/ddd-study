package jp.co.biglobe.isp.domain.member;


public interface MemberRepository {

    public BiglobeId 識別子を作成する();

    public void 入会する(Member member);

    public void 退会する(Member member);

    public Member biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId);
}
