package com.ifsuldemias.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifsuldemias.course.entities.enums.OrderStatus;
@Entity
@Table(name="tb_order")//Renomeando a tabela
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Formatando a data no formato ISO 
	@JsonFormat(shape  = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instant;// Registra o momento
	private Integer orderStatus;
	@ManyToOne
	@JoinColumn(name="cliend_id")
	private Users client;

	public Order() {

	}

	public Order(Long id, Instant instant, Users client,OrderStatus orderStatus) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public Users getClient() {
		return client;
	}

	public void setClient(Users client) {
		this.client = client;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus!=null) {
			this.orderStatus = orderStatus.getCode();
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(client, id, instant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(client, other.client) && Objects.equals(id, other.id)
				&& Objects.equals(instant, other.instant);
	}

}
