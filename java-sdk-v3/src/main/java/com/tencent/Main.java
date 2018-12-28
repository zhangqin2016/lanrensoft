package com.tencent;

import com.tencent.common.HttpsRequest;
import com.tencent.common.Signature;
import com.tencent.common.Util;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderReqData;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {

            //--------------------------------------------------------------------
            //温馨提示，第一次使用该SDK时请到com.tencent.file.Configure类里面进行配置
            //--------------------------------------------------------------------



            //--------------------------------------------------------------------
            //PART One:基础组件测试
            //--------------------------------------------------------------------

            //1）https请求可用性测试
            //HTTPSPostRquestWithCert.test();

            //2）测试项目用到的XStream组件，本项目利用这个组件将Java对象转换成XML数据Post给API
            //XStreamTest.test();


            //--------------------------------------------------------------------
            //PART Two:基础服务测试
            //--------------------------------------------------------------------

            //1）测试被扫支付API
            //PayServiceTest.test();

            //2）测试被扫订单查询API
            //PayQueryServiceTest.test();

            //3）测试撤销API
            //温馨提示，测试支付API成功扣到钱之后，可以通过调用PayQueryServiceTest.test()，将支付成功返回的transaction_id和out_trade_no数据贴进去，完成撤销工作，把钱退回来 ^_^v
            //ReverseServiceTest.test();

            //4）测试退款申请API
            //RefundServiceTest.test();

            //5）测试退款查询API
            //RefundQueryServiceTest.test();

            //6）测试对账单API
            //DownloadBillServiceTest.test();


            //本地通过xml进行API数据模拟的时候，先按需手动修改xml各个节点的值，然后通过以下方法对这个新的xml数据进行签名得到一串合法的签名，最后把这串签名放到这个xml里面的sign字段里，这样进行模拟的时候就可以通过签名验证了
           // Util.log(Signature.getSignFromResponseString(Util.getLocalXMLString("/test/com/tencent/business/refundqueryserviceresponsedata/refundquerysuccess2.xml")));

            //Util.log(new Date().getTime());
            //Util.log(System.currentTimeMillis());
    /*        UnifiedOrderReqData unifiedOrderReqData = new UnifiedOrderReqData("1","1","1","1",1,"1","1");
            WXPay.doUnifiedOrderBusiness(unifiedOrderReqData);*/
           // UnifiedOrderReqData{appid='wx90b2e9aa5c70aaac', mch_id='1363723202', device_info='WEB', nonce_str='5ir9tv0hh90fc3oy879h2g578ndl6d03', sign='335D7CE91C6B065F05A39CAF67235770', body='斑斑-奇幻斑斑', attach='奇幻斑斑', out_trade_no='201608310937352890001', total_fee=14652, spbill_create_ip='49.5.1.107', time_start='20160831093935', time_expire='20160831094035', goods_tag='ZC', notify_url='http://www.qq.com', trade_type='NATIVE', product_id='201608310937352890001', limit_pay='no_credit'}

        } catch (Exception e){
            Util.log(e.getMessage());
        }

    }

}
