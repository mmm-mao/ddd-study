package jp.co.biglobe.isp.domain.member.member_life_cycle;

import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUp;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpDate;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.NotExistWithdrawal;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.ValidWithdrawal;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.Withdrawal;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class MemberLifeCycle {

    private final SignUp signUp;

    private final Withdrawal withdrawal;

    private MemberStatus 契約状態を判定する(){

        if(withdrawal.申込済みか()){
            ValidWithdrawal validWithdrawal = (ValidWithdrawal)withdrawal;
            return validWithdrawal.契約状態を判定する();
        }

        return MemberStatus.入会中;
    }


    public static MemberLifeCycle 入会する(){
        return new MemberLifeCycle(SignUp.作成する(), new NotExistWithdrawal());
    }

    public MemberLifeCycle 退会する(){
        return new MemberLifeCycle(signUp, ValidWithdrawal.月末退会で作成する());
    }

    public boolean 入会中か(){
        return 契約状態を判定する().入会中か();
    }

    public boolean 退会できるか(){

        if(withdrawal.申込済みか()){
            return false;
        }

        return true;
    }

}
