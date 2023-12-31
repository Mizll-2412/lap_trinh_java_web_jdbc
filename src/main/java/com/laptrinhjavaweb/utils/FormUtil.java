package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil{
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static <T> T toModel(Class<T> TClasss,HttpServletRequest request)
	{
		T object=null;
		try {
			object=TClasss.newInstance();
			//get keys
		BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException|InvocationTargetException |IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return object;
	}

}
