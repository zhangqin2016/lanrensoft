package zhang.lao.console.model.common;


import zhang.lao.console.model.login.LoginUserModel;

/**
 * Created by tech6 on 2016/8/23.
 */
public class ConsoleContext {

    private LoginUserModel loginUserModel;

    public LoginUserModel getLoginUserModel() {
        return loginUserModel;
    }

    public void setLoginUserModel(LoginUserModel loginUserModel) {
        this.loginUserModel = loginUserModel;
    }

    public Integer getUserId(){
        if(loginUserModel==null){
            return null;
        }else{
            return Integer.parseInt(loginUserModel.getUser_id());
        }
    }
    public String getStrUserId(){
        if(loginUserModel==null){
            return null;
        }else{
            return loginUserModel.getUser_id();
        }
    }
}
