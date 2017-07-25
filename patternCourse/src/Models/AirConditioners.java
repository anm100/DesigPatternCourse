package Models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.Logger;
import Utils.MyConnection;

public class AirConditioners extends Product{
private  AirConditioners thisRef=this;
	public static List<AirConditioners> getProducts(){
		try {
			return MyConnection.getCon().getHandler().airConditioners.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public  boolean updateProduct(){
		try {
			Logger.getInstance().debug("update product in database ");
			 MyConnection.getCon().getHandler().airConditioners.update(thisRef);
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@Override
	public void getProduct(int sid) {
		Logger.getInstance().debug("get product from database ");
		 try {
			Logger.getInstance().debug("get product from database ");
			setProduct(MyConnection.getCon().getHandler().airConditioners.queryForId(sid)) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
