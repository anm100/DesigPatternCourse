package Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

public abstract class Insurance  extends BaseDaoEnabled implements Serializable,DaoInterface {
	
	@DatabaseField(generatedId = true)
	private int sid;

	
	@DatabaseField()
	private String ClientID;
	
	@DatabaseField()
	private String 	Numberofpolicy ; 

	@DatabaseField()
	private String CompanyInsurance;
	
	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date startDate;
	
	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date endDate;
	
	
	@DatabaseField()
	private int price;
	

	
	
	public String getNumberofpolicy() {
		return Numberofpolicy;
	}

	public void setNumberofpolicy(String numberofpolicy) {
		Numberofpolicy = numberofpolicy;
	}

	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}

	public String getCompanyInsurance() {
		return CompanyInsurance;
	}

	public void setCompanyInsurance(String companyInsurance) {
		CompanyInsurance = companyInsurance;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public int getSid() {
		return sid;
	}

	public void setInsurance( Insurance p ){
		this.sid=p.sid;
		this.ClientID=p.ClientID;
		this.startDate=p.startDate;
		this.endDate=p.endDate;
		this.price=p.price;
		this.CompanyInsurance = p.CompanyInsurance;
		
	}
	
}