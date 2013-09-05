package fr.imie.formation;

import java.util.List;

import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		List<UtilisateurDTO> listUtil = null;

		try {
			listUtil= DAOFactory1.getInstance().createUtilisateurService(null).readAllUtilisateur();
		} catch (TransactionalConnectionException e) {
		
			
		} catch (ServiceException e) {
			
			
		}


		for(UtilisateurDTO util:listUtil){
			System.out.println("Adresse"+util.getAdresse());
			System.out.println("mail"+ util.getMail());
			System.out.println("nom"+util.getNom());
			System.out.println("prenom"+util.getPrenom());
			System.out.println("tel"+util.getTel());
			System.out.println("login"+util.getLogin());
			System.out.println("password"+util.getPassword());
			System.out.println("age"+util.getDateNaissance());
		}

	}

}
