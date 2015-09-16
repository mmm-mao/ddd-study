package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.UserId;
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

        有効に戻す(validAuth.getUserId(), creditCard);

    }


    private void 検証する(ValidAuth validAuth, CreditCard creditCard){

        biglobeAuthService.サービス利用不可をNGとして認証する(validAuth);

        CreditCardRegisterStatus creditCardRegisterStatus = creditCardCheckService.受け付ける(creditCard);
        if(!creditCardRegisterStatus.登録できるか()){
            throw new RuntimeException("新しいクレジットカードが無効です");
        }
    }

    private void 有効に戻す(UserId userId, CreditCard creditCard){
        ValidCreditEntity validCreditCardEntity = creditCardRepository._biglobeIdで検索する_存在しなかったらエラー(userId);
        creditCardRepository.変更する(validCreditCardEntity.変更する(creditCard.getCreditCardNumber()));

    }


}
