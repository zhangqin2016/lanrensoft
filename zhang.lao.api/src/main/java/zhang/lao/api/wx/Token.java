package zhang.lao.api.wx;

/**
 * @author
 * @create 2018-04-03 17:08
 **/
public class Token {
    private Token() {}
    private  String token;
    private static Token instance  = new Token();
    public static Token getInstance() {
        return instance;
    }
    public  String getToken() {
        return token;
    }
    public  void setToken(String token) {
        this.token = token;
    }
}