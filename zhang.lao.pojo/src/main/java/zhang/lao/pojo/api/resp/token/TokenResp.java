package zhang.lao.pojo.api.resp.token;


import zhang.lao.pojo.api.resp.ApiRespBody;

public class TokenResp extends ApiRespBody {

	private String token;
	
	private String createTime;
	
	private String outTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
}