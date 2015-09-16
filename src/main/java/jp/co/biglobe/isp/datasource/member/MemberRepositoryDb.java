package jp.co.biglobe.isp.datasource.member;


import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.Member;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryDb implements MemberRepository {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードのドメイン biglobeidとBIGLOBEパスワードのドメイン;

    @Autowired
    private MemberQueryMapper memberQueryMapper;

    @Override
    public BiglobeId 識別子を作成する(){
        return new BiglobeId(biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEIDを発番するメソッド());
    }

    @Override
    public void 入会する(Member member){
        memberQueryMapper.signUp(member);
    }

    public void 退会する(Member member){
        memberQueryMapper.withdrawal(member);
    }

    @Override
    public Member biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId){
        Member member = memberQueryMapper.findByBiglobeId(biglobeId);
        if(member == null){
            throw new UnsupportedOperationException("指定された会員が存在しない");
        }

        return member;
    }


}
