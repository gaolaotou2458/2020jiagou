package com.atguigu.memento.theory;

/**
 * 备忘录对象，负责保存好记录，即Originator内部状态
 */
public class Memento {
	private String state;

	public Memento(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
