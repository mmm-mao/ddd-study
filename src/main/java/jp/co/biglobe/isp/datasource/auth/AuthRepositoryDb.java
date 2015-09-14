package jp.co.biglobe.isp.datasource.auth;


import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.auth.AuthRepository;
import jp.co.biglobe.isp.domain.auth.BiglobePassword;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepositoryDb implements AuthRepository {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードのドメイン biglobeidとBIGLOBEパスワードのドメイン;

    @Override
    public BiglobePassword パスワードを作成する(){
        return new BiglobePassword(biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEパスワードを発番するメソッド());
    }

    @Override
    public void 登録する(ValidAuth validAuth){

    }

    @Override
    public ValidAuth _Idとパスワードで検索する(ValidAuth validAuth){
        return new ValidAuth(new UserId("abc12345"), new BiglobePassword("adfefwrfew"));
    }

}
