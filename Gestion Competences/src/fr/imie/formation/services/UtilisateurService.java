package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class 



UtilisateurService extends ATransactional implements
		IUtilisateurService {

	// UTILISATEUR

	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, ServiceException {

		List<UtilisateurDTO> listUtilisateur = new ArrayList<UtilisateurDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listUtilisateur = iDaoFactory.createIUtilisateurDAO(this)
					.readAllUtilisateur();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listUtilisateur;

	}

	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		UtilisateurDTO util = new UtilisateurDTO();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			util = iDaoFactory.createIUtilisateurDAO(this).readUtilisateur(
					utilisateurDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return util;

	}

	public int createUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int numCreate = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numCreate = iDaoFactory.createIUtilisateurDAO(this).createUtilisateur(
					utilisateurDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numCreate;

	}

	public int updateUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int numUpdate = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numUpdate = iDaoFactory.createIUtilisateurDAO(this).updateUtilisateur(
					utilisateurDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numUpdate;

	}

	public int deleteUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int numDelete = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numDelete = iDaoFactory.createIUtilisateurDAO(this).deleteUtilisateur(
					utilisateurDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numDelete;

	}

	public boolean logUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		boolean boolLog = false;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			boolLog = iDaoFactory.createIUtilisateurDAO(this).logUtilisateur(
					utilisateurDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boolLog;

	}

	@Override
	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		
		List<UtilisateurDTO> listUtilisateur = new ArrayList<UtilisateurDTO>();
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			return iDaoFactory.createIUtilisateurDAO(this).readUtilisateurProjet(projet);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUtilisateur;
	}

}
