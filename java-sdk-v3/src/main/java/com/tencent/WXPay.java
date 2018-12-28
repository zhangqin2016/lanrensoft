package com.tencent;

import com.tencent.business.*;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedOrderRespData;
import com.tencent.protocol.unifiedorder_protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.unifiedorder_protocol.refund_protocol.RefundResData;

/**
 * SDK总入口
 */
public class WXPay {
    public static UnifiedOrderRespData doUnifiedOrderBusiness(UnifiedOrderReqData unifiedOrderReqData) throws Exception {
        return new UnifiedOrderBusiness().run(unifiedOrderReqData);
    }

    public static RefundResData doRefundBusiness(RefundReqData refundReqData) throws Exception {
        return new RefundBusiness().run(refundReqData);
    }

}
