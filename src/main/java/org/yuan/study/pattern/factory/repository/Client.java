package org.yuan.study.pattern.factory.repository;

public class Client {

	public static void main(String[] args) {
		Repository repo = new Repository();
		Hello hello = (Hello)repo.getBean("hello");
		hello.print();
		
		System.out.println("Singleton：" + (hello == repo.getBean("hello")));
	}

}
