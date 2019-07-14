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
		this.setProductionYear(null);
		Logger.getInstance().debug("add to database ");
		try {
			MyConnection.getCon().getHandler().airConditioners.create(thisRef);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void deleteProduct() {
		Logger.getInstance().debug("delete product from database ");
		 try {
			Logger.getInstance().debug("get product from database ");
			MyConnection.getCon().getHandler().airConditioners.deleteById(getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
