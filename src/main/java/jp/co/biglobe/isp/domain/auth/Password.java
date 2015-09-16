package jp.co.biglobe.isp.domain.auth;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class Password {

    private final String value;

}
