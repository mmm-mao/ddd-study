package jp.co.biglobe.isp.domain.member_profile.profile.address;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {

    private final AddressText addressText;

    private final ZipCode zipCode;
}
