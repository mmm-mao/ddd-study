package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardCheckService {


    @Autowired
    private CreditCardRepository creditCardRepository;



    public CreditCardRegisterStatus 受け付ける(CreditCard creditCard){

        ValidCreditCardStatus validCreditCardStatus = creditCardRepository.有効かチェックする(creditCard);

        Credit credit = creditCardRepository.クレジットカード番号で検索する(creditCard.getCreditCardNumber());

        return credit.is変更できる(validCreditCardStatus);

    }

    public CreditCardRegisterStatus 無効から元に戻せるか確認する(CreditCard creditCard, BiglobeId biglobeId){

        ValidCreditCardStatus validCreditCardStatus = creditCardRepository.有効かチェックする(creditCard);

        Credit credit = creditCardRepository.クレジットカード番号で検索する(creditCard.getCreditCardNumber());

        return credit.is無効から有効に戻せる(validCreditCardStatus, biglobeId);

    }

}
