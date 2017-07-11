package com.haozi.taker.intf.bean.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @className:com.haozi.taker.intf.bean.common.ReqBean
 * @description:一般请求bean
 * @version:v1.0.0
 * @date:2017年5月17日 下午1:12:15
 * @author:WangHao
 */
@ApiModel(value = "一般请求bean")
public class ReqBean
{
	@ApiModelProperty(value = "请求id")
	private String id;

	@ApiModelProperty(value = "请求token")
	private String token;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	@Override
	public String toString()
	{
		return "ReqBean [id=" + id + ", token=" + token + "]";
	}
}
