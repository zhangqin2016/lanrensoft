package com.tencent.protocol.unifiedorder_protocol.jsapi;

import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tech6 on 2016/9/6.
 */
public class JsApiPayModel {
            private String appId;    //公众号名称，由商户传入
    private String timeStamp;  //时间戳，自1970年以来的秒数
    private String nonceStr; //随机串
    private String _package ;
    private String signType="MD5";        //微信签名方式：
    private String paySign; //微信签名

    public JsApiPayModel(String _package) {
        setAppId(Configure.getAppid());
      setTimeStamp(new Date().getTime()/1000+"");
        //随机字符串，不长于32 位
        setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
        this._package = _package;
        String sign = Signature.getSign(toMap());
        setPaySign(sign);//把签名数据设置到Sign这个属性中
    }
    public JsApiPayModel(String _package,String appid) {
        setAppId(appid);
        setTimeStamp(new Date().getTime()/1000+"");
        //随机字符串，不长于32 位
        setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
        this._package = _package;
        String sign = Signature.getSign(toMap());
        setPaySign(sign);//把签名数据设置到Sign这个属性中
    }
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String get_package() {
        return _package;
    }

    public void set_package(String _package) {
        this._package = _package;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    if(field.getName().equals("paySign")){
                        continue;
                    }
                    if(field.getName().equals("_package")){
                        map.put("package", obj);
                    }else{
                        map.put(field.getName(), obj);
                    }

                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
