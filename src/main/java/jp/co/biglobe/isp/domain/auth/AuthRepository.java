package jp.co.biglobe.isp.domain.auth;


public interface AuthRepository {

    public Password パスワードを作成する();

    public void 登録する(ValidAuth validAuth);

    public Auth _Idとパスワードで検索する_存在しなかったらエラー(ValidAuth validAuth);
}
