package db;

import Models.Payment;
import Models.CarInsurance;
import Models.Client;
import Models.OtherInsurance;
import Models.CustomerClaims;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


/**
 * Database Handler, the main class that intializes, fills and controls the
 * database using DAO objects.
 * 
 * @author aj_pa
 *
 */
public class DbHandler {

	private ConnectionSource connection;

	public Dao<CarInsurance, Integer> CarInsurance;
	public Dao<Client, Integer> client;
	public Dao<CustomerClaims, Integer> customerClaims;

	public Dao<OtherInsurance, Integer> OtherInsurance;


	/**
	 * need to provide url , user ,pass to conncet to database
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public DbHandler(String url, String username, String password) {
		try {
			connection = new JdbcConnectionSource(url, username, password);
			createAllTables();
			initializeDao();
		//	fillDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * fills the database with random data.
	 * 
	 * @throws Exception
	 */
	public void fillDataBase() throws Exception {
		DataFiller df = new DataFiller(this);
	}
		
	public void initializeDao() throws Exception {
		CarInsurance = DaoManager.createDao(connection, CarInsurance.class);
		OtherInsurance = DaoManager.createDao(connection, OtherInsurance.class);
		client = DaoManager.createDao(connection, Client.class);
		customerClaims = DaoManager.createDao(connection, CustomerClaims.class);


	}

	/**
	 * creates all the tables using ORM, it also drops the tables first
	 * 
	 * @throws Exception
	 */
	public void createAllTables() throws Exception {
		TableUtils.dropTable(connection, CarInsurance.class,true);
		TableUtils.dropTable(connection, Client.class,true);
		TableUtils.dropTable(connection, OtherInsurance.class,true);
		TableUtils.dropTable(connection, CustomerClaims.class,true);

		
		TableUtils.createTable(connection, Client.class);
		TableUtils.createTable(connection, CustomerClaims.class);
		TableUtils.createTable(connection, CarInsurance.class);
		TableUtils.createTable(connection, OtherInsurance.class);

	}
}
