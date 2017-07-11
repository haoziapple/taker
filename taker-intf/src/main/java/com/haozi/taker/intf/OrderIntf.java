package com.haozi.taker.intf;

import com.haozi.taker.intf.bean.order.SubmitOrderInfo;
import com.haozi.taker.intf.bean.order.SubmitOrderRsp;

/**
 * @className:com.haozi.taker.intf.OrderIntf
 * @description:订单接口
 * @version:v1.0.0
 * @date:2017年5月17日 下午1:04:49
 * @author:WangHao
 */
public interface OrderIntf
{
	// 提交订单
	SubmitOrderRsp submitOrder(SubmitOrderInfo submitOrderInfo);
}
