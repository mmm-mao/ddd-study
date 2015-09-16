package jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExistWithdrawal implements Withdrawal{

    @Override
    public boolean is申込済み(){
        return false;
    }

    @Override
    public boolean is退会できる(){
        return true;
    }
}
