package zhang.lao.pojo.console.login;


import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangqin on 2017/3/11.
 */
public class LoginReq {

    @NotBlank(message = "账户/手机号/邮箱不能为空")
    private String userAccount;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    private String captcha;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
