package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.service.auth.BiglobeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardChangeService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardCheckService creditCardCheckService;

    @Autowired
    private BiglobeAuthService biglobeAuthService;
    
    public void 受け付ける(ValidAuth validAuth, CreditCard creditCard){

        検証する(validAuth, creditCard);

        変更する(validAuth.getBiglobeId(), creditCard);

    }


    private void 検証する(ValidAuth validAuth, CreditCard creditCard){

        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

        CreditCardRegisterStatus creditCardRegisterStatus = creditCardCheckService.受け付ける(creditCard);
        if(!creditCardRegisterStatus.登録できるか()){
            throw new UnsupportedOperationException("新しいクレジットカードが無効です");
        }
    }

    private void 変更する(BiglobeId biglobeId, CreditCard creditCard){
        ValidCredit validCreditCardEntity = creditCardRepository.biglobeIdで検索する_存在しなかったらエラー(biglobeId);
        creditCardRepository.変更する(validCreditCardEntity.変更する(creditCard.getCreditCardNumber()));

    }


}
