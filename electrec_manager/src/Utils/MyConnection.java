package Utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

	private String dbUrl ;
	private String dbUser;
	private String dbPassword;
	private static DbHandler handler;
	private final static MyConnection instance = new MyConnection();

	private MyConnection() {
	    try {

		File fXmlFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("databaseConnection");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				dbUrl= eElement.getElementsByTagName("url").item(0).getTextContent();
				dbUser=eElement.getElementsByTagName("username").item(0).getTextContent();
				dbPassword=eElement.getElementsByTagName("password").item(0).getTextContent();

			}
		}
	    } catch (Exception e) {
	    	dbUrl="jdbc:mysql://localhost/test";
	    	dbUser="root";
	    	dbPassword="123123";
		e.printStackTrace();
	    }
		handler=new DbHandler(dbUrl, dbUser, dbPassword);
	}


	public static MyConnection getCon() {
		return instance;
	}

	public void printConfig() {

		Logger.getInstance().debug("[CONFIGURATION]");
		Logger.getInstance().debug("\t|URL : " + dbUrl);
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

	public DbHandler getHandler() {
		return handler;
	}
	
	public void setHandler(DbHandler handler) {
		this.handler = handler;
	}


}
