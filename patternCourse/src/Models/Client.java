package Models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

import Utils.Logger;
import Utils.MyConnection;

public class Client  extends BaseDaoEnabled implements Serializable,DaoInterface {
	private  Client thisRef=this;

	@DatabaseField(generatedId = true)
	private int cid;

	@DatabaseField()
	private String ClientID;
	
	@DatabaseField()
	private String FirstName;

	
	@DatabaseField()
	private String LastName;

	public Client() {
		
	}
	public static List<Client> getItems(){
		try {
			return MyConnection.getCon().getHandler().client.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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

	public void setClient( Client p ){
		this.cid=p.cid;
		this.ClientID=p.ClientID;
		this.FirstName=p.FirstName;
		this.LastName=p.LastName;
			
	}
	
	public  boolean updateItem(){
		try {
			Logger.getInstance().debug("update item in database ");
			 MyConnection.getCon().getHandler().client.update(thisRef);
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
			MyConnection.getCon().getHandler().client.create(thisRef);
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
		Logger.getInstance().debug("get item from database ");
		 try {
			Logger.getInstance().debug("get item from database ");
			setClient(MyConnection.getCon().getHandler().client.queryForId(sid)) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
}