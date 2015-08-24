package jp.co.biglobe.isp.domain.auth;


public interface AuthRepository {

    public BiglobePassword パスワードを作成する();

    public void 登録する(ValidAuth validAuth);

    public Auth _Idとパスワードで検索する(ValidAuth validAuth);
}
