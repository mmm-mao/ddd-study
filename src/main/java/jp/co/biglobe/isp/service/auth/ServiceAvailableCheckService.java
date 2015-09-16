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

        ValidCreditEntity validCreditCardEntity = creditCardRepository.biglobeIdで検索する_存在しなかったらエラー(biglobeId);

        if(validCreditCardEntity.無効か()){
            throw new UnsupportedOperationException("サービスが利用できません");
        }


    }

}
