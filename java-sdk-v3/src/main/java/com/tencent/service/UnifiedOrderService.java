package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderReqData;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 16:03
 */
public class UnifiedOrderService extends BaseService{

    public UnifiedOrderService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.UNIFIEDORDER_API);
    }

    /**
     * 请求支付服务
     * @param unifiedOrderReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(UnifiedOrderReqData unifiedOrderReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(unifiedOrderReqData);

        return responseString;
    }
}
