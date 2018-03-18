package org.skiphackaton.services.order;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItem {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		private Integer orderId;
		private Integer productId;
		private BigDecimal price;
		private Integer quantity;
		private BigDecimal total;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer product) {
			this.productId = product;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getTotal() {
			return total;
		}
		public void setTotal(BigDecimal total) {
			this.total = total;
		}
		
		public Integer getOrderId() {
			return orderId;
		}
		
		public void setOrderId(Integer order) {
			this.orderId = order;
		}
}
