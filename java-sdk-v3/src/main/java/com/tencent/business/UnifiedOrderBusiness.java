package com.tencent.business;

import com.tencent.common.*;
import com.tencent.common.report.ReporterFactory;
import com.tencent.common.report.protocol.ReportReqData;
import com.tencent.common.report.service.ReportService;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderRespData;
import com.tencent.service.UnifiedOrderService;
import com.tencent.service.UnifiedOrderService;

import static java.lang.Thread.sleep;

/**
 * User: rizenguo
 * Date: 2014/12/1
 * Time: 17:05
 */
public class UnifiedOrderBusiness {

    public UnifiedOrderBusiness() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        unifiedOrderService = new UnifiedOrderService();
    }


    //打log用

    //每次调用订单查询API时的等待时间，因为当出现支付失败的时候，如果马上发起查询不一定就能查到结果，所以这里建议先等待一定时间再发起查询

    private int waitingTimeBeforePayQueryServiceInvoked = 5000;

    //循环调用订单查询API的次数
    private int payQueryLoopInvokedCount = 3;

    //每次调用撤销API的等待时间
    private int waitingTimeBeforeReverseServiceInvoked = 5000;

    private UnifiedOrderService unifiedOrderService;

    /**
     * 直接执行被扫支付业务逻辑（包含最佳实践流程）
     *
     * @param unifiedOrderReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @throws Exception
     */
    public UnifiedOrderRespData run(UnifiedOrderReqData unifiedOrderReqData) throws Exception {


        //接受API返回
        String payServiceResponseString;

        long costTimeStart = System.currentTimeMillis();


        System.out.println("支付API返回的数据如下：");
        payServiceResponseString = unifiedOrderService.request(unifiedOrderReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        System.out.println("api请求总耗时：" + totalTimeCost + "ms");

        //打印回包数据
        System.out.println(payServiceResponseString);

        //将从API返回的XML数据映射到Java对象
        UnifiedOrderRespData unifiedOrderResData = (UnifiedOrderRespData) Util.getObjectFromXML(payServiceResponseString, UnifiedOrderRespData.class);

        //异步发送统计请求
        //*
        return  unifiedOrderResData;
    }


}
