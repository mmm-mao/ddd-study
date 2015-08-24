package jp.co.biglobe.outsource.service;

import jp.co.biglobe.outsource.domain.クレジットカードのドメイン;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class クレジットカードが有効かチェックするサービス {

    @Autowired
    private クレジットカードのドメイン _クレジットカードのドメイン;

    public boolean check(String creditCardNumber, String effectiveMonth, String securityNumber) {

        return _クレジットカードのドメイン.check(creditCardNumber, effectiveMonth, securityNumber);
    }

}
