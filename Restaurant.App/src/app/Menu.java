package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@Column(name="sn")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int sn;
	
	@Column(name="item_name")
	String itemName;
	
	@Column(name="rate")
	float  rate;
	
	
	public String getItemName() {
		return itemName;
	}
	public float getRate() {
		return rate;
	}
	public void setItemName(String name) {
		this.itemName = itemName;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "\n"+ sn +"\t\t"+ itemName + "\t\t"+ rate ;
	}
	
	
	

}
