package jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignUp {

    private final SignUpDate signUpDate;

    public static SignUp 作成する(){
        return new SignUp(SignUpDate.作成する());
    }

}
