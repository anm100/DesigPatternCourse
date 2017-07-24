package Models;

import java.io.Serializable;
import java.sql.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

public abstract class products  extends BaseDaoEnabled implements Serializable  {
	
	@DatabaseField(id = true)
	private String sid;
	
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

}
