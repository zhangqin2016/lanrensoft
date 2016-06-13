/*
 * Copyright (c) 2016 太阳花互动科技. All Rights Reserved.
 */
package zhang.lao.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test {

	public static void main(String[] args) {
		CloseableHttpClient c = HttpClients.custom().build();
		HttpPost httpPost = new HttpPost("http://10.10.1.199:9999/sunarvr/api/statistics/fitting?uid=1&openid=1a92306bdf55d785bd914502e220f40a&token=B737B12D1188C9F0A82E032FDD70B9D7E8C9F800D4B74EC2BEB5F394CED39EEF&goods_id=1");
		try {
			for (int i = 0; i < 1000; i++) {
				
			
		    HttpResponse response = c.execute(httpPost);

            HttpEntity entity = response.getEntity();

			System.out.println(EntityUtils.toString(entity, "UTF-8")+"00000");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
