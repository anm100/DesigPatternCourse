package Utils;

import db.DbHandler;

/**
 * Class Config, the configuration of the server.
 * @author aj_pa
 *
 */
public class MyConnection {
	private boolean isDebug = true;
	public boolean isDebug() {
		return isDebug;
	}

	public void setDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}

	private int port = 5000;
	private String dbUrl = "jdbc:mysql://localhost/test";
	private String dbUser = "root";
	private String dbPassword = "123123";
	private static DbHandler handler;
	private final static MyConnection instance = new MyConnection();

	private MyConnection() {
		handler=new DbHandler(dbUrl, dbUser, dbPassword);

	}

	public static MyConnection getCon() {
		return instance;
	}

	public void printConfig() {

		Logger.getInstance().debug("[CONFIGURATION]");
		Logger.getInstance().debug("\t|URL : " + dbUrl);
		Logger.getInstance().debug("\t|PORT : " + port);
		Logger.getInstance().debug("\t|USER : " + dbUser);
		Logger.getInstance().debug("\t|PASSWORD : " + dbPassword);
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public DbHandler getHandler() {
		return handler;
	}

	public void setHandler(DbHandler handler) {
		this.handler = handler;
	}


}
