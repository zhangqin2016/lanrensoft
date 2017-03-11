package zhang.lao.api.service.token;

import com.lz.kit.LogKit;
import com.lz.kit.ehcache.CacheKit;
import com.lz.tool.TokenTool;
import com.lz.tool.date.DateStyle;
import com.lz.tool.date.DateUtil;
import org.springframework.stereotype.Component;
import zhang.lao.api.constant.CacheKey;
import zhang.lao.api.service.common.ApiAppInfoService;
import zhang.lao.api.service.common.TokenService;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.req.token.TokenReq;
import zhang.lao.pojo.api.resp.ApiRespData;
import zhang.lao.pojo.api.resp.ApiResultCode;
import zhang.lao.pojo.api.resp.token.TokenResp;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 
* @ClassName: TokenService 
* @Description:token
* @author zhangqin
* @date 2016年4月15日 下午2:04:31 
*
 */
@Component
public class ApiTokenService {
	//token服务类
	@Resource
	private TokenService tokenService;

	@Resource
	private ApiAppInfoService apiAppInfoService;
	final String MSGFAILD="时间戳已经过期";
	final String MSGCREATETOKENF="系统创建token失败";
	final String MSGSINGERROR="签名错误";
	/**
	 * 获取token
	 * @param tokenReq
	 * @return
	 */
	public ApiRespData<TokenResp> getToken(ApiReqData<TokenReq> tokenReq){
			long time=new Date().getTime()/1000;
			TokenReq req=tokenReq.getBody();
			if(time- new Long(req.getT())>10&&time- new Long(req.getT())<0){
				return ApiRespData.buildFail(ApiResultCode.FAIL,MSGFAILD);
			}else{
				String appid=req.getAppid();
				String openid=req.getOpenid();
				String t=req.getT();
				String h=req.getH();
			if(apiAppInfoService.verify(appid, t, h,openid)){
				try{
					String token= TokenTool.getToken(appid);
					//config.tokenlive
					Date date=new Date();
					Long now=date.getTime()+new Long(60*60*24)*1000;
					Date dateNow=new Date(now);
					if(tokenService.createToken(openid,token,date,dateNow)){
						CacheKit.put(CacheKey.CACHEKEY, openid + ":" + token, token);
						TokenResp resp=new TokenResp();
						resp.setCreateTime(DateUtil.DateToString(date, DateStyle.YYYY_MM_DD_HH_MM_SS));
						resp.setOutTime(DateUtil.DateToString(dateNow, DateStyle.YYYY_MM_DD_HH_MM_SS));
						resp.setToken(token);
						return ApiRespData.buildSucc(resp);
					}else{
						return ApiRespData.buildFail(ApiResultCode.FAIL,MSGCREATETOKENF);
					}
				}catch(Exception e){
					LogKit.error(e.getMessage(),e);
					return ApiRespData.buildFail(ApiResultCode.FAIL,MSGCREATETOKENF);
				}
			}else{
				return ApiRespData.buildFail(ApiResultCode.FAIL,MSGSINGERROR);
			}	
			}

	}
}
