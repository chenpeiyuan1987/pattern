package org.yuan.study.pattern.factory.repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Repository {
	private static final Map<String,BeanWrapper> BEANS;
	static {
		BEANS = new HashMap<String,BeanWrapper>();
		try {
			Properties prop = new Properties();
			InputStream in = Repository.class.getResourceAsStream("beans.properties");
			prop.load(in);
			
			for(Object obj : prop.keySet()) {
				String key = obj.toString();
				if(key.contains(".")) {
					continue;
				}
				
				boolean singleton = Boolean.parseBoolean(prop.getProperty(key + ".singleton"));
				Class<?> clazz = Class.forName(prop.getProperty(key));
				BeanWrapper beanWrapper = new BeanWrapper(clazz, singleton);
				BEANS.put(key, beanWrapper);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String id) {
		BeanWrapper beanWrapper = BEANS.get(id);
		Object bean = beanWrapper.getExample();
		return bean;
	}
}
