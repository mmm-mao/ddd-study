package jp.co.biglobe.isp.domain.credit_card;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class CreditCardNumber {

    @Getter
    private final String value;

}
