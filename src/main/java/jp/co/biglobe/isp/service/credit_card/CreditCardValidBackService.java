package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidBackService {


    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardCheckService creditCardCheckService;


    public void 受け付ける(UserId userId, CreditCard creditCard){

        検証する(userId, creditCard);

        有効に戻す(userId, creditCard);

    }


    private void 検証する(UserId userId, CreditCard creditCard){


        CreditCardRegisterStatus creditCardRegisterStatus = creditCardCheckService.受け付ける(creditCard);
        if(!creditCardRegisterStatus.登録できるか()){
            creditCardRepository.送付されてきたクレジットカード情報が無効だと通知する(userId);
            throw new RuntimeException("新しいクレジットカードが無効です");
        }

    }

    private void 有効に戻す(UserId userId, CreditCard creditCard){
        ValidCreditEntity validCreditCardEntity = creditCardRepository._biglobeIdで検索する(userId);
        creditCardRepository.有効に戻す(validCreditCardEntity.有効に戻す(creditCard.getCreditCardNumber()));

    }


}
