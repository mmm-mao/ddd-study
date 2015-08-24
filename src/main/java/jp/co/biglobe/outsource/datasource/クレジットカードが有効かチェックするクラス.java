package jp.co.biglobe.outsource.datasource;

import jp.co.biglobe.outsource.domain.クレジットカードのドメイン;
import org.springframework.stereotype.Repository;

@Repository
public class クレジットカードが有効かチェックするクラス implements クレジットカードのドメイン {
    @Override
    public boolean check(String creditCardNumber, String effectiveMonth, String securityNumber) {
        return true;
    }
}
