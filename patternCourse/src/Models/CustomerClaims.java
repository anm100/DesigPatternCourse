package Models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

import Utils.Logger;
import Utils.MyConnection;

public class CustomerClaims  extends BaseDaoEnabled implements Serializable,DaoInterface {
	private  CustomerClaims thisRef=this;

	@DatabaseField(generatedId = true)
	private int cid;

	@DatabaseField()
	private String ClientID;
	
	@DatabaseField()
	private String InsuranceType;

	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date CreationDate;
	
	@DatabaseField()
	private String Description;

	public CustomerClaims() {
		
	}
	
	public String getInsuranceType() {
		return InsuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		InsuranceType = insuranceType;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public static List<CustomerClaims> getItems(){
		try {
			return MyConnection.getCon().getHandler().customerClaims.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	


	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}




	public void setSid(int sid) {
		this.cid = sid;
	}

	public int getSid() {
		return cid;
	}


	
	public  boolean updateItem(){
		try {
			Logger.getInstance().debug("update item in database ");
			 MyConnection.getCon().getHandler().customerClaims.update(thisRef);
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	@Override
	public void addItem() {
		// TODO Auto-generated method stub
		Logger.getInstance().debug("add item to database ");
		try {
			MyConnection.getCon().getHandler().customerClaims.create(thisRef);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void deleteItem() {
		Logger.getInstance().debug("delete item from database ");
		 try {
			Logger.getInstance().debug("get item from database ");
			MyConnection.getCon().getHandler().client.deleteById(getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}		
	
	@Override
	public void getItem(int sid) {
//		Logger.getInstance().debug("get item from database ");
//		 try {
//			Logger.getInstance().debug("get item from database ");
//			//setClient(MyConnection.getCon().getHandler().client.queryForId(sid)) ;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}

	
}