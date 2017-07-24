package db;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Models.AirConditioners;
import Models.Refrigerators;
import Models.VacuumCleaners;
import Utils.DateTime;


public class DataFiller {

	DbHandler db;
	public static String[] firstNames = { "John", "Tyrion", "Arya", "Sandor", "Euron", "Dyneris", "Ned", "Cersi", "Sam",
			"Sansa", "Ramsey", "Roose", "Robert", "Walder", "Jora", "Varys", "Mountain", "Yara", "Jaime", "Stannis",
			"Renly", "Robert" };
	public static String[] lastNames = { "Blackfrey", "Martel", "River", "Andal", "Lanister", "Bolton", "Stark",
			"Clegane", "Targeryan", "Greyjoy", "Weiss", "Drogo", "Karstak", "Turlly", "Mormont", "Frey", "Baratheon",
			"Slavador", "Snow" };
	public static String[] cities = { "King's Landing", "Winterfell", "Iron Islands", "Valyeria", "The Wall" };

	public static String[] specialities = { "Surgon", "Oncologe", "Urologe", "Cardiologe", "Bone", "Family",
			"Children" };

	public static String[] eTypes = { "Blood", "Urine", "CT", "ECG", "X-Ray", "Eye", "CAT" };

	public static Random rand = new Random();

	public DataFiller(DbHandler d) {
		db = d;

	}

	public void fillAirConditioners() throws SQLException {
		for (int i = 0; i < 10; i++) {
			AirConditioners d = new AirConditioners();
			d.setPrice(800+ rand.nextInt(2000));
			d.setProductionYear(Utils.DateTime.getDate(2000 + rand.nextInt(16), rand.nextInt(12), rand.nextInt(29)));
			d.setProductName("AirConditioners home_"+i);
			d.setQuantity(500+ rand.nextInt(100));
			db.airConditioners.create(d);
		}

	}
	public void fillRefrigerators() throws SQLException {
		for (int i = 0; i < 10; i++) {
			Refrigerators d = new Refrigerators();
			d.setPrice(800+ rand.nextInt(2000));
			d.setProductionYear(Utils.DateTime.getDate(2000 + rand.nextInt(16), rand.nextInt(12), rand.nextInt(29)));
			d.setProductName("Refrigerators_"+i);
			d.setQuantity(500+ rand.nextInt(100));
			db.refrigerators.create(d);
		}

	}
	public void fillVacuumCleaners() throws SQLException {
		for (int i = 0; i < 10; i++) {
			VacuumCleaners d = new VacuumCleaners();
			d.setPrice(800+ rand.nextInt(2000));
			d.setProductionYear(Utils.DateTime.getDate(2000 + rand.nextInt(16), rand.nextInt(12), rand.nextInt(29)));
			d.setProductName("Refrigerators_"+i);
			d.setQuantity(500+ rand.nextInt(100));
			db.vacuumCleaners.create(d);
		}

	}



}
