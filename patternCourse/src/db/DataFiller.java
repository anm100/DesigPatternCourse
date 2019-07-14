package db;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Models.CarInsurance;
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




}
