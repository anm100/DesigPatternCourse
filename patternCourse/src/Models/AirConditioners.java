package Models;

import java.sql.SQLException;
import java.util.List;

import Utils.MyConnection;

public class AirConditioners extends products{
	
	public static List <AirConditioners> getProducts(){
		
		try {
			return MyConnection.getCon().getHandler().airConditioners.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
