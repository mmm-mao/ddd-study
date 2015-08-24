package jp.co.biglobe.outsource.service;

import jp.co.biglobe.outsource.domain.BIGLOBEIDとBIGLOBEパスワードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BIGLOBEIDとBIGLOBEパスワードを発番するサービス {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードのドメイン biglobeidとBIGLOBEパスワードのドメイン;

    public String BIGLOBEID発番() {
        return biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEIDを発番するメソッド();
    }

    public String BIGLOBEパスワード発番() {
        return biglobeidとBIGLOBEパスワードのドメイン.BIGLOBEパスワードを発番するメソッド();
    }

}
