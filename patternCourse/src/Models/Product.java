package Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

public class Product  extends BaseDaoEnabled implements Serializable,DaoInterface {
	
	@DatabaseField(generatedId = true)
	private int sid;

	
	@DatabaseField()
	private String productName;

	@DatabaseField()
	private Date productionYear;
	
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

	public Date getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
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

	@Override
	public boolean updateProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}
	
}