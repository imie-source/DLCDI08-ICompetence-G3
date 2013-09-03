package fr.imie.formation.utils;

import java.util.Calendar;
import java.util.Date;

public class AgeUtil {
	// Constructeur privé
	private AgeUtil() {
	}

	// Instance unique pré-initialisée
	private static AgeUtil INSTANCE = new AgeUtil();

	// Point d'accès pour l'instance unique du singleton
	public static synchronized AgeUtil getInstance() {
		if (INSTANCE == null)
			INSTANCE = new AgeUtil();
		return INSTANCE;
	}

	public int getAge(Date dateNaissance) {

		int age = 0;
		if (dateNaissance != null) {

			Calendar dob = Calendar.getInstance();
			dob.setTime(dateNaissance);
			Calendar today = Calendar.getInstance();
			age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
			if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
				age--;
			} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
					&& today.get(Calendar.DAY_OF_MONTH) < dob
							.get(Calendar.DAY_OF_MONTH)) {
				age--;
			}
		}
		return age;
	}

}
