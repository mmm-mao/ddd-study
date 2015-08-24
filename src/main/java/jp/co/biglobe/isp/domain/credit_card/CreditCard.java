package jp.co.biglobe.isp.domain.credit_card;

import jp.co.biglobe.isp.domain.member.BiglobeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CreditCard {

    @Getter
    private final CreditCardNumber creditCardNumber;

    @Getter
    private final EffectiveMonth effectiveMonth;

    @Getter
    private final SecurityNumber securityNumber;

}
