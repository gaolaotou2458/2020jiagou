package com.atguigu.builder;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonHouse commonHouse = new CommonHouse();
		commonHouse.build();
		System.out.println("=====����========");
		BieShuHouse bieShuHouse = new BieShuHouse();
		bieShuHouse.build();
	}

}
