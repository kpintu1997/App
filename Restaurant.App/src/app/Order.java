package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	
	@Column(name="cust_name")
	String customerName;
	
	@Column(name="ord_item")
	String orderedItem;
	
	@Column(name="item_qty")
	int quantity;
	
	@Column(name="table_number")
	int tableNo;

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getOrderedItem() {
		return orderedItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrderedItem(String orderedItem) {
		this.orderedItem = orderedItem;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "\n"+orderId +"\t\t"+customerName+"\t\t"+orderedItem+"\t\t"+quantity;
	}
	
	
	

}

