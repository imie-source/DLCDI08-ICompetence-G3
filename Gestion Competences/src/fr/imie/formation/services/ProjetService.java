  package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.InvitationDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IProjetService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProjetService extends ATransactional implements IProjetService {

	// PROJET
	@Override
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, ServiceException {

		List<ProjetDTO> listProjet = new ArrayList<ProjetDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listProjet = iDaoFactory.createIProjetDAO(this).readAllProjets();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return listProjet;
	}

	public List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException {

		List<ProjetDTO> listeProjetUtilisateur = new ArrayList<ProjetDTO>();
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listeProjetUtilisateur= iDaoFactory.createIProjetDAO(this).readProjetByUtilisateur(utilisateur);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeProjetUtilisateur;
		
	}

	@Override
	public ProjetDTO readProjet(ProjetDTO projetDTO)
			throws TransactionalConnectionException, ServiceException {

		ProjetDTO projet = new ProjetDTO();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			projet = iDaoFactory.createIProjetDAO(this).readProjet(projetDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projet;
	}

	@Override
	public int ajoutChefDeProjet(ProjetDTO projetDTO)
			throws TransactionalConnectionException, ServiceException {

		int numAjoutCDP = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numAjoutCDP = iDaoFactory.createIProjetDAO(this).ajoutChefDeProjet(
					projetDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numAjoutCDP;

	}

	@Override
	public int createProjet(ProjetDTO projetDTO)
			throws TransactionalConnectionException, ServiceException {

		int numCreate = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numCreate = iDaoFactory.createIProjetDAO(this).createProjet(projetDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numCreate;
	}

	@Override
	public int updateProjet(ProjetDTO projetDTO)
			throws TransactionalConnectionException, ServiceException {

		int numUpdate = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numUpdate = iDaoFactory.createIProjetDAO(this).updateProjet(projetDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numUpdate;
	}

	@Override
	public int deleteProjet(ProjetDTO projetDTO)
			throws TransactionalConnectionException, ServiceException {

		int numDelete = 0;

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			numDelete = iDaoFactory.createIProjetDAO(this).deleteProjet(projetDTO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numDelete;
	}

	// STATUT PROJET
	@Override
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, ServiceException {

		List<StatutProjetDTO> listStatusProj= new ArrayList<StatutProjetDTO>();

		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listStatusProj = iDaoFactory.createIStatutProjetDAO(this).readAllStatutProjet();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStatusProj;
	}
	
	public StatutProjetDTO readStatutProjet(StatutProjetDTO statutProjet)
			throws TransactionalConnectionException, ServiceException {
		StatutProjetDTO statut = new StatutProjetDTO();
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			statut = iDaoFactory.createIStatutProjetDAO(this).readStatutProjet(statutProjet);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statut;
	}

	
	public int addProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
         int addNum = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			addNum = iDaoFactory.createIProjetDAO(this).addProjetUtil(utilisateur,projet);
					
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addNum;
	}

	public int updateProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
         int updateNum = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			updateNum = iDaoFactory.createIProjetDAO(this).updateProjetUtil(utilisateur,projet);
					
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateNum;
	}
		
		public int deleteProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
				throws TransactionalConnectionException, ServiceException {
	         int deleteNum = 0;
			
			IDAOFactory iDaoFactory = DAOFactory1.getInstance();
			try {
				deleteNum = iDaoFactory.createIProjetDAO(this).deleteProjetUtil(utilisateur,projet);
						
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return deleteNum;
		}
	

// invitation

public  List<InvitationDTO> readAllInvitation(ProjetDTO projet)
		throws TransactionalConnectionException, ServiceException {
	
	List<InvitationDTO> listAllInvitation = new ArrayList<InvitationDTO>();
	IDAOFactory iDaoFactory = DAOFactory1.getInstance();

	try {
		listAllInvitation=iDaoFactory.createIInvitationDAO(this).readAllInvitation(projet);
	} catch (DAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	return listAllInvitation;
	
}
}
