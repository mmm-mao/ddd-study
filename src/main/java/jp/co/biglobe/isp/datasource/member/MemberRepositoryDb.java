package jp.co.biglobe.isp.datasource.member;


import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryDb implements MemberRepository {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードのドメイン biglobeidとBIGLOBEパスワードのドメイン;

    @Override
    public BiglobeId 識別子を作成する(){
        return new BiglobeId(biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEIDを発番するメソッド());
    }

    @Override
    public void 入会する(MemberEntity memberEntity){}

    public void 退会する(MemberEntity memberEntity){}

    @Override
    public MemberEntity BiglobeIdで検索する(BiglobeId biglobeId){
        return MemberEntity.入会する(biglobeId);
    }


}
