package fr.imie.formation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringUtil {

	// Constructeur privé
	private DateStringUtil() {
	}

	// Instance unique pré-initialisée
	private static DateStringUtil INSTANCE = new DateStringUtil();

	// Point d'accès pour l'instance unique du singleton
	public static synchronized DateStringUtil getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DateStringUtil();
		return INSTANCE;
	}

	public Date getDateString(String stringDate) {

		java.sql.Date dateOk = null;

		try {
			SimpleDateFormat date = new SimpleDateFormat("dd-mm-yyyy");
			Date dateJava = date.parse(stringDate);
			dateOk = new java.sql.Date(dateJava.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateOk;
	}
}
