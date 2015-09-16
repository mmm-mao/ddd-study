package jp.co.biglobe.isp.service.credit_card;

import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidBackService {


    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardCheckService creditCardCheckService;


    public void 受け付ける(BiglobeId biglobeId, CreditCard creditCard){

        検証する(biglobeId, creditCard);

        有効に戻す(biglobeId);

    }


    private void 検証する(BiglobeId biglobeId, CreditCard creditCard){


        CreditCardRegisterStatus creditCardRegisterStatus = creditCardCheckService.無効から元に戻せるか確認する(creditCard, biglobeId);
        if(!creditCardRegisterStatus.is登録できる()){
            creditCardRepository.送付されてきたクレジットカード情報が無効だと通知する(biglobeId);
            throw new UnsupportedOperationException("新しいクレジットカードが無効です");
        }

    }

    private void 有効に戻す(BiglobeId biglobeId){
        ValidCredit validCreditCardEntity = creditCardRepository.biglobeIdで検索する_存在しなかったらエラー(biglobeId);
        creditCardRepository.有効に戻す(validCreditCardEntity.有効に戻す());

    }


}
