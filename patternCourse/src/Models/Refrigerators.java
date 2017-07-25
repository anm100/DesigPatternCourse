package Models;

import java.sql.SQLException;
import java.util.List;

import Utils.Logger;
import Utils.MyConnection;

public class Refrigerators extends Product{

	private  Refrigerators thisRef=this;
	public static List<Refrigerators> getProducts(){
		try {
			return MyConnection.getCon().getHandler().refrigerators.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public  boolean updateProduct(){
		try {
			Logger.getInstance().debug("update product in database ");
			 MyConnection.getCon().getHandler().refrigerators.update(thisRef);
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
			MyConnection.getCon().getHandler().refrigerators.create(thisRef);
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
			MyConnection.getCon().getHandler().refrigerators.deleteById(getSid());
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
			setProduct(MyConnection.getCon().getHandler().refrigerators.queryForId(sid)) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
