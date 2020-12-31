package com.atguigu.responsibilitychain;

public class DepartmentApprover extends Approver {

	
	public DepartmentApprover(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void processRequest(PurchaseRequest purchaseRequest) {
		// TODO Auto-generated method stub
		if(purchaseRequest.getPrice() <= 5000) {
			System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
		}else {
			System.out.println("当前角色处理不了,向下流转");
			approver.processRequest(purchaseRequest);
		}
	}

}
