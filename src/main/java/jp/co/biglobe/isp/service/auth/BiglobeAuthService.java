package jp.co.biglobe.isp.service.auth;

import jp.co.biglobe.isp.domain.auth.Auth;
import jp.co.biglobe.isp.domain.auth.AuthRepository;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.member.MemberEntity;
import jp.co.biglobe.isp.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiglobeAuthService {

    @Autowired
    private ServiceAvailableCheckService serviceAvailableCheckService;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void サービス利用不可をNGとして認証する(ValidAuth validAuth){

        サービス利用不可をOKとして認証する(validAuth);

        serviceAvailableCheckService.チェックする(validAuth.getUserId());

    }

    public void サービス利用不可をOKとして認証する(ValidAuth validAuth){

        Auth auth = authRepository._Idとパスワードで検索する_存在しなかったらエラー(validAuth);

        MemberEntity memberEntity = memberRepository.BiglobeIdで検索する_存在しなかったらエラー(validAuth.getUserId());

        if(auth.認証OKか(memberEntity)){
            return;
        }

        throw new RuntimeException("認証できません");

    }

}
