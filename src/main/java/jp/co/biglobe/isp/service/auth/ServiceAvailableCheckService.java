package jp.co.biglobe.isp.service.auth;

import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCreditEntity;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAvailableCheckService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public void チェックする(BiglobeId biglobeId){

        ValidCreditEntity validCreditCardEntity = creditCardRepository._biglobeIdで検索する(biglobeId);

        if(validCreditCardEntity.無効か()){
            throw new RuntimeException("サービスが利用できません");
        }


    }

}
