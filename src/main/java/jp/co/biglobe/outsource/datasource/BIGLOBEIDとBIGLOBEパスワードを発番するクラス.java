package jp.co.biglobe.outsource.datasource;

import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.stereotype.Repository;

@Repository
public class BIGLOBEIDとBIGLOBEパスワードを発番するクラス implements BIGLOBEIDとBIGLOBEパスワードのドメイン {

    @Override
    public String BIGLOBEIDを発番するメソッド() {
        return "abc12345";
    }

    @Override
    public String BIGLOBEパスワードを発番するメソッド() {
        return "!\"#$%&'()0=~|";
    }

}
