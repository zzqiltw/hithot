package utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) throws IllegalAccessException, InvocationTargetException {
		T bean = null;
		try {
			bean = beanClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Enumeration<String> e = request.getParameterNames();
		
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			BeanUtils.setProperty(bean, name, value);
			
		}
		
		return bean;
		
	}
	
	public static void copyBean(Object src, Object tar) {
		try {
			BeanUtils.copyProperties(tar, src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
