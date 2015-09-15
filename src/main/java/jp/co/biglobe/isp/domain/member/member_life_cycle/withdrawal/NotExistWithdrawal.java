package jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistWithdrawal implements Withdrawal{

    @Override
    public boolean 申込済みか(){
        return false;
    }
}
