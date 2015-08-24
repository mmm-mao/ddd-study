package jp.co.biglobe.isp.domain.member_profile.profile.phone_number;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneNumber {

    private final ContractPhoneNumber contractPhoneNumber;

    private final DaytimePhoneNumber daytimePhoneNumber;
}
