package jp.co.biglobe.isp.domain.member;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class BiglobeId {

    private final String value;

    public boolean is同一ID(BiglobeId biglobeId){
        return this.equals(biglobeId);
    }

}
