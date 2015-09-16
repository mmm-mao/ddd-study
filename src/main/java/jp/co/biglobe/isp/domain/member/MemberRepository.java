package jp.co.biglobe.isp.domain.member;


public interface MemberRepository {

    public BiglobeId 識別子を作成する();

    public void 入会する(MemberEntity memberEntity);

    public void 退会する(MemberEntity memberEntity);

    public MemberEntity biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId);
}
