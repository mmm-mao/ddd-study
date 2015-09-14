package jp.co.biglobe.isp.domain.member;


public interface MemberRepository {

    public UserId 識別子を作成する();

    public void 入会する(MemberEntity memberEntity);

    public void 退会する(MemberEntity memberEntity);

    public MemberEntity BiglobeIdで検索する(UserId userId);
}
