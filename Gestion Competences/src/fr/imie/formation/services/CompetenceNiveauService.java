package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class CompetenceNiveauService extends ATransactional implements
		ICompetenceNiveauService {

	// COMPETENCE

	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, DAOException {

		List<CompetenceDTO> listCompetence = new ArrayList<CompetenceDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		listCompetence = iDaoFactory.createICompetenceDAO(this)
				.readAllCompetence();

		return listCompetence;

	}

	// NIVEAU

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		List<NiveauDTO> listNiveau = new ArrayList<NiveauDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		listNiveau = iDaoFactory.createINiveauDAO(this)
				.readCompetenceNiveauUtilisateur(utilisateur);

		return listNiveau;
	}

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			DAOException {

		List<NiveauDTO> listNiveau = new ArrayList<NiveauDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		listNiveau = iDaoFactory.createINiveauDAO(this)
				.readNiveauUtilisateurCompetence(competence);

		return listNiveau;
	}

}
