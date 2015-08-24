package jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal;

import jp.co.biglobe.isp.domain.member.member_life_cycle.MemberStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidWithdrawal implements Withdrawal{

    private final WithdrawalDate withdrawalDate;

    public static ValidWithdrawal 月末退会で作成する(){
        return new ValidWithdrawal(WithdrawalDate.月末日で作成する());

    }


    @Override
    public boolean 申込済みか(){
        return true;
    }

    public MemberStatus 契約状態を判定する(){

        if(withdrawalDate.過去日か()){
            return MemberStatus.退会済み;
        }
        
        return MemberStatus.退会予約中;
    }

}
