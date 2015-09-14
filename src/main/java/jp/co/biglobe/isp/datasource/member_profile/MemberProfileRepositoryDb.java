package jp.co.biglobe.isp.datasource.member_profile;


import jp.co.biglobe.isp.domain.member_profile.MemberProfileEntity;
import jp.co.biglobe.isp.domain.member_profile.MemberProfileRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberProfileRepositoryDb implements MemberProfileRepository {

    @Override
    public void 登録する(MemberProfileEntity memberProfileEntity){}


}
