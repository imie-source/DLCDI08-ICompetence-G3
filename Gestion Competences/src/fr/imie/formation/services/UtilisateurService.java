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
			throws TransactionalConnectionException, DAOException {

		UtilisateurDTO util = new UtilisateurDTO();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		util = iDaoFactory.createIUtilisateurDAO(this).readUtilisateur(
				utilisateurDTO);

		return util;

	}

	public int createUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		return iDaoFactory.createIUtilisateurDAO(this).createUtilisateur(
				utilisateurDTO);

	}

	public int updateUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		return iDaoFactory.createIUtilisateurDAO(this).updateUtilisateur(
				utilisateurDTO);

	}

	public int deleteUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		return iDaoFactory.createIUtilisateurDAO(this).deleteUtilisateur(
				utilisateurDTO);

	}

	public boolean logUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		return iDaoFactory.createIUtilisateurDAO(this).logUtilisateur(
				utilisateurDTO);

	}

	@Override
	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		return iDaoFactory.createIUtilisateurDAO(this).readUtilisateurProjet(projet);
	}

}
