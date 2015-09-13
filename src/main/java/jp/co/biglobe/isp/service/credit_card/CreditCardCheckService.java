package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.credit_card.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardCheckService {


    @Autowired
    private CreditCardRepository creditCardRepository;



    public CreditCardRegisterStatus 受け付ける(CreditCard creditCard){

        ValidCreditCardStatus validCreditCardStatus = creditCardRepository.有効かチェックする(creditCard);

        CreditEntity creditEntity = creditCardRepository.クレジットカード番号で検索する(creditCard.getCreditCardNumber());

        return creditEntity.変更できるか(validCreditCardStatus);

    }

}