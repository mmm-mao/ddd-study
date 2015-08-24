package jp.co.biglobe.isp.datasource.member_profile;


import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileEntity;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileRepository;
import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberProfileRepositoryDb implements MemberProfileRepository {

    @Override
    public void 登録する(MemberProfileEntity memberProfileEntity){}


}
