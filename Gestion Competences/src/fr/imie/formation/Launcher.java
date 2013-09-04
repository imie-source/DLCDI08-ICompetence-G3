package fr.imie.formation;

import java.util.List;

import fr.imie.formation.DAO.PromotionDAO;
import fr.imie.formation.DAO.UtilisateurDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.PromotionDTO;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
