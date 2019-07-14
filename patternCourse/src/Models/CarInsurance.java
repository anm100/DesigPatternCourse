package Models;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;

import Utils.Logger;
import Utils.MyConnection;

public class CarInsurance extends Insurance implements DaoInterface{

	private  CarInsurance thisRef=this;
	
	@DatabaseField
	private String CarNumber ;
	
	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}

	public static List<CarInsurance> getItems(){
		try {
			return MyConnection.getCon().getHandler().CarInsurance.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public  boolean updateItem(){
		try {
			Logger.getInstance().debug("update CarInsurance in database ");
			 MyConnection.getCon().getHandler().CarInsurance.update(thisRef);
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
			MyConnection.getCon().getHandler().CarInsurance.create(thisRef);
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
			MyConnection.getCon().getHandler().CarInsurance.deleteById(getSid());
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
			setInsurance(MyConnection.getCon().getHandler().CarInsurance.queryForId(sid)) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
