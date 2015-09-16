package jp.co.biglobe.isp.datasource.member;


import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
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
    public void 入会する(MemberEntity memberEntity){
        memberQueryMapper._signUp(memberEntity);
    }

    public void 退会する(MemberEntity memberEntity){}

    @Override
    public MemberEntity biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId){
        MemberEntity memberEntity = memberQueryMapper.findByBiglobeId(biglobeId);
        if(memberEntity == null){
            throw new UnsupportedOperationException("指定された会員が存在しない");
        }

        return memberEntity;
    }


}
