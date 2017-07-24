package db;

import Models.AirConditioners;
import Models.Refrigerators;
import Models.VacuumCleaners;

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

	public Dao<Refrigerators, String> refrigerators;
	public Dao<AirConditioners, String> airConditioners;

	public Dao<VacuumCleaners, String> vacuumCleaners;


	/**
	 * need to provide url , user ,pass to conenct to database
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
//			fillDataBase();
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
		df.fillClinics();
		df.fillDoctors();
		df.fillPatients();
		df.fillconfirmation();
		df.fillMedicalRecords();
		df.fillAppointments();
		df.fillStatistics();
		df.fillShifts();
		df.fillDispatchers();
		df.fillManagers();
	}

	/**
	 * initializes all the DAO for ORM usage
	 * 
	 * @throws Exception
	 */
	public void initializeDao() throws Exception {
		refrigerators = DaoManager.createDao(connection, Refrigerators.class);
		airConditioners = DaoManager.createDao(connection, AirConditioners.class);
		vacuumCleaners = DaoManager.createDao(connection, VacuumCleaners.class);

	}

	/**
	 * creates all the tables using ORM, it also drops the tables first
	 * 
	 * @throws Exception
	 */
	public void createAllTables() throws Exception {
//		TableUtils.dropTable(connection, Manager.class, true);
//		TableUtils.dropTable(connection, Param.class, true);


		TableUtils.createTable(connection, Refrigerators.class);
		TableUtils.createTable(connection, AirConditioners.class);
		TableUtils.createTable(connection, VacuumCleaners.class);
	}
}
