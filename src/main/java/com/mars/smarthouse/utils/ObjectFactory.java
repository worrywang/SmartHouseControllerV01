package com.mars.smarthouse.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ObjectFactory {
	private static final Map<String,Object> objectMap=new HashMap<String,Object>();
	public static synchronized <T extends Object> T createInstance(Class<T> tClass) {
		try {
			if(objectMap.containsKey(tClass.getName())){
				return (T)objectMap.get(tClass.getName());
			}
			return (T) Class.forName(tClass.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
