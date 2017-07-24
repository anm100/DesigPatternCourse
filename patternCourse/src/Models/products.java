package Models;

import java.io.Serializable;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

public abstract class products  extends BaseDaoEnabled implements Serializable  {
	
	@DatabaseField(generatedId = true)
	private int sid;
	
	/**
	 * The person last name 
	 */
	@DatabaseField()
	private String productName;
	/**
	 * The person first name 
	 */
	@DatabaseField()
	private Date productionYear;
	
	@DatabaseField()
	private int price;
	
	/**
	 * The person phone 
	 */
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
	
	

}
