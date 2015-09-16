package jp.co.biglobe.isp.domain.member.member_life_cycle;

import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUp;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.NotExistWithdrawal;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.ValidWithdrawal;
import jp.co.biglobe.isp.domain.member.member_life_cycle.withdrawal.Withdrawal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberLifeCycle {

    private final SignUp signUp;

    private final Withdrawal withdrawal;

    public MemberLifeCycle(SignUp signUp, ValidWithdrawal validWithdrawal){
        this.signUp = signUp;
        this.withdrawal = validWithdrawal == null ? new NotExistWithdrawal() : validWithdrawal;
    }

    private MemberStatus 契約状態を判定する(){

        if(withdrawal.is申込済み()){
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

    public boolean is入会中(){
        return 契約状態を判定する().is入会中();
    }

    public boolean is退会できる(){

        return withdrawal.is退会できる();

    }

}
