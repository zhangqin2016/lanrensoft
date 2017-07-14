package zhang.lao.pojo.console.common;


import zhang.lao.pojo.console.login.LoginUserModel;

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

    public String getUserId(){
        if(loginUserModel==null){
            return null;
        }else{
            return loginUserModel.getUser_id();
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
