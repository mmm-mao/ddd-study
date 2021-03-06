package jp.co.biglobe.isp.datasource.auth;


import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.auth.AuthRepository;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepositoryDb implements AuthRepository {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードのドメイン biglobeidとBIGLOBEパスワードのドメイン;

    @Autowired
    private AuthQueryMapper authQueryMapper;

    @Override
    public Password パスワードを作成する(){
        return new Password(biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEパスワードを発番するメソッド());
    }

    @Override
    public void 登録する(ValidAuth validAuth){
        authQueryMapper.register(validAuth);
    }

    @Override
    public ValidAuth _Idとパスワードで検索する_存在しなかったらエラー(ValidAuth validAuth){
        ValidAuth resultValidAuth =  authQueryMapper.findByBiglobeIdAndPassword(validAuth);

        if(resultValidAuth == null){
            throw new UnsupportedOperationException("IDとパスワードの組み合わせが不一致");
        }

        return resultValidAuth;
    }

}
