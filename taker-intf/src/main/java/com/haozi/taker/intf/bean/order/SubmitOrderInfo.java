package com.haozi.taker.intf.bean.order;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.haozi.taker.intf.bean.common.ReqBean;
import com.haozi.taker.intf.bean.goods.GoodsInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @className:com.haozi.taker.intf.bean.order.SubmitOrderInfo
 * @description:提交订单请求bean
 * @version:v1.0.0
 * @date:2017年5月17日 下午1:32:12
 * @author:WangHao
 */

@ApiModel("提交订单请求bean")
public class SubmitOrderInfo extends ReqBean
{
	@NotBlank(message = "用户id为空")
	@ApiModelProperty("用户id")
	private String userId;
	@ApiModelProperty("订单总价")
	private String totalPrice;
	@ApiModelProperty("商品列表")
	private List<GoodsInfo> goodsList;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public List<GoodsInfo> getGoodsList()
	{
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfo> goodsList)
	{
		this.goodsList = goodsList;
	}

	@Override
	public String toString()
	{
		return "SubmitOrderInfo [userId=" + userId + ", totalPrice=" + totalPrice + ", goodsList=" + goodsList
				+ ", toString()=" + super.toString() + "]";
	}
}
