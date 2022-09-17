package com.ifsuldemias.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ifsuldemias.course.entities.pk.OrderItemPk;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPk id;

	private Integer quantity;
	private Double price;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
		this.id.setOrder(order);
		this.id.setProduct(product);
	}

	public Order getOrder() {
		return this.id.getOrder();
	}

	public void setOrder(Order order) {
		this.id.setOrder(order);
	}

	public Product getProdutct() {
		return this.id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
