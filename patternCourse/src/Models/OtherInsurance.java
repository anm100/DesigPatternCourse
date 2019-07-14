package Models;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;

import Utils.Logger;
import Utils.MyConnection;

public class OtherInsurance extends Insurance{

	private  OtherInsurance thisRef=this;
	
	@DatabaseField
	private String type ;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static List<OtherInsurance> getItems(){
		try {
			return MyConnection.getCon().getHandler().OtherInsurance.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public  boolean updateItem(){
		try {
			Logger.getInstance().debug("update CarInsurance in database ");
			 MyConnection.getCon().getHandler().OtherInsurance.update(thisRef);
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
		Logger.getInstance().debug("add CarInsurance to database ");
		try {
			MyConnection.getCon().getHandler().OtherInsurance.create(thisRef);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void deleteItem() {
		Logger.getInstance().debug("delete product from database ");
		 try {
			Logger.getInstance().debug("get product from database ");
			MyConnection.getCon().getHandler().OtherInsurance.deleteById(getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}		
	
	@Override
	public void getItem(int sid) {
		Logger.getInstance().debug("get product from database ");
		 try {
			Logger.getInstance().debug("get product from database ");
			setInsurance(MyConnection.getCon().getHandler().OtherInsurance.queryForId(sid)) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
