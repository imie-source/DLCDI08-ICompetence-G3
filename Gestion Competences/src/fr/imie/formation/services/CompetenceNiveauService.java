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

	public CompetenceDTO readCompetence(CompetenceDTO competenceDTO)
			throws TransactionalConnectionException, ServiceException {

		CompetenceDTO competence = new CompetenceDTO();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			competence = iDaoFactory.createICompetenceDAO(this)
					.readCompetence(competenceDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return competence;

	}

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


	public List<CompetenceDTO> readListeUtilComp(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {

		List<CompetenceDTO>listeUtilComp=new ArrayList<CompetenceDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listeUtilComp = iDaoFactory.createICompetenceDAO(this)
					.readListeUtilComp(competenceDto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeUtilComp;

	}
	public int addCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)		
			throws TransactionalConnectionException, ServiceException {

		int addNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			addNum = iDaoFactory.createINiveauDAO(this).addCompUtil(utilisateur,comp,niveau);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addNum;

	}
	public int updateCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)		
			throws TransactionalConnectionException, ServiceException {

		int updateNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			updateNum = iDaoFactory.createINiveauDAO(this).updateCompUtil(utilisateur,comp,niveau);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateNum;

	}
	public int deleteCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)		
			throws TransactionalConnectionException, ServiceException {

		int deleteNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			deleteNum = iDaoFactory.createINiveauDAO(this).deleteCompUtil(utilisateur,comp,niveau);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteNum;

	}

	public int createCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {

		int createNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			createNum = iDaoFactory.createICompetenceDAO(this).createCompetence(
					competenceDto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createNum;

	}
	
	public int updateCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {

		int updateNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			updateNum = iDaoFactory.createICompetenceDAO(this).updateCompetence(
					competenceDto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateNum;

	}
	
	public int deleteCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {

		int deleteNum = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			deleteNum = iDaoFactory.createICompetenceDAO(this).deleteCompetence(
					competenceDto);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteNum;

	}
	
}
