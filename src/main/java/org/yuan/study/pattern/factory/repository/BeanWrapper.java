package org.yuan.study.pattern.factory.repository;

public class BeanWrapper {
	
	public BeanWrapper(Class<?> clazz, boolean singleton) {
		this.clazz = clazz;
		this.singleton = singleton;
		
		if(singleton) {
			example = getObject();
		}
	}

	public Object getExample() {
		if(singleton) {
			return example;
		}
		
		return getObject();
	}
	
	private Object getObject() {
		Object bean = null;
		
		try {
			bean = clazz.newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	private Object example;
	private boolean singleton;
	private Class<?> clazz;
}
