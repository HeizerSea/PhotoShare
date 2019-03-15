package com.demo.photoshare.utils;


import com.demo.photoshare.common.JsonBean;

public class JsonBeanUtils {
	
	public static JsonBean createJsonBean(int code, Object info) {
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		return bean;
	}
}
