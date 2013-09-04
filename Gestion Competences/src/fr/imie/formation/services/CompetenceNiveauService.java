package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class CompetenceNiveauService extends ATransactional implements
		ICompetenceNiveauService {

	// COMPETENCE

	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, ServiceException {

		List<CompetenceDTO> listCompetence = new ArrayList<CompetenceDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listCompetence = iDaoFactory.createICompetenceDAO(this)
					.readAllCompetence();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCompetence;

	}

	// NIVEAU

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException {

		List<NiveauDTO> listNiveau = new ArrayList<NiveauDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listNiveau = iDaoFactory.createINiveauDAO(this)
					.readCompetenceNiveauUtilisateur(utilisateur);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNiveau;
	}

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			ServiceException {

		List<NiveauDTO> listNiveau = new ArrayList<NiveauDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listNiveau = iDaoFactory.createINiveauDAO(this)
					.readNiveauUtilisateurCompetence(competence);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNiveau;
	}

}
