package com.ifsuldemias.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;

	private OrderStatus(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	//Retorna o orderStatus do Enum ex:1  = Waiting_Payment
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value:OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code");
	}
}
