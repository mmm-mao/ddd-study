package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.CreditCardRepository;
import jp.co.biglobe.isp.domain.credit_card.ValidCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardInValidService {


    @Autowired
    private CreditCardRepository creditCardRepository;



    public void 受け付ける(CreditCardNumber creditCardNumber){

        ValidCredit validCreditCardEntity = creditCardRepository.クレジットカード番号で検索する_存在しなかったらエラー(creditCardNumber);

        creditCardRepository.無効にする(validCreditCardEntity.無効にする());

        creditCardRepository.無効になったことを通知する(validCreditCardEntity.getBiglobeId());

    }




}
