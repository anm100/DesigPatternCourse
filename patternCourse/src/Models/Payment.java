package Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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


	public void addProduct() {
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}

	public void getProduct(int sid) {
		// TODO Auto-generated method stub
		
	}
	
}