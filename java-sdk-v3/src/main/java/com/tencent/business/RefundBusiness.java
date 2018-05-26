package com.tencent.business;

import com.tencent.WXPay;
import com.tencent.common.Configure;
import com.tencent.common.Log;
import com.tencent.common.Signature;
import com.tencent.common.Util;
import com.tencent.common.report.ReporterFactory;
import com.tencent.common.report.protocol.ReportReqData;
import com.tencent.common.report.service.ReportService;
import com.tencent.protocol.unifiedorder_protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.unifiedorder_protocol.refund_protocol.RefundResData;
import com.tencent.service.RefundService;
import org.slf4j.LoggerFactory;

/**
 * User: rizenguo
 * Date: 2014/12/2
 * Time: 17:51
 */
public class RefundBusiness {

    public RefundBusiness() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        refundService = new RefundService();
    }


    //打log用
    private static Log log = new Log(LoggerFactory.getLogger(RefundBusiness.class));

    //执行结果
    private static String result = "";

    private RefundService refundService;

    /**
     * 调用退款业务逻辑
     * @param refundReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @throws Exception
     */
    public RefundResData run(RefundReqData refundReqData) throws Exception {

        //--------------------------------------------------------------------
        //构造请求“退款API”所需要提交的数据
        //--------------------------------------------------------------------

        //API返回的数据
        String refundServiceResponseString;

        long costTimeStart = System.currentTimeMillis();


        log.i("退款查询API返回的数据如下：");
        refundServiceResponseString = refundService.request(refundReqData);


        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");

        log.i(refundServiceResponseString);

        //将从API返回的XML数据映射到Java对象
        RefundResData refundResData = (RefundResData) Util.getObjectFromXML(refundServiceResponseString, RefundResData.class);
        return  refundResData;
    }

}
