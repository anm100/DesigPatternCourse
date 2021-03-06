package Models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Utils.MyConnection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

public class Payment  extends BaseDaoEnabled implements Serializable {
	
	
	@DatabaseField(generatedId = true)
	private int sid;
	
	@DatabaseField()
	private String productName;

	@DatabaseField()
	private int price;
	
	@DatabaseField()
	private int quantity;
	
	
	public Payment(int sid, String productName, int price, int quantity) {
		super();
		this.sid = sid;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSid() {
		return sid;
	}

	
}