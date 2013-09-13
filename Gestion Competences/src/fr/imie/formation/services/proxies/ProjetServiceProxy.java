package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DTO.InvitationDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.ProjetService;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IProjetService;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProjetServiceProxy implements IProjetService{

	private ProjetService projetService;

	ITransactional caller = null;

	public ProjetServiceProxy (ProjetService projetService, ITransactional caller){
		super();
		this.projetService = projetService;
		this.caller = caller;
	}

	@Override
	public Connection getConnection() {

		return projetService.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		projetService.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		projetService.putInTransaction(caller);

	}

	@Override
	public void putOffTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endTransactionalConnexion() {
		projetService.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		projetService.beginTransactionalConnexion();

	}

	@Override
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, ServiceException {
		List<ProjetDTO> listProjet = new ArrayList<ProjetDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listProjet = projetService.readAllProjets();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listProjet;
	}


	@Override
	public List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException {

		List<ProjetDTO> listeProjetUtilisateur= new ArrayList<ProjetDTO>();

		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeProjetUtilisateur = projetService.readProjetByUtilisateur(utilisateur);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeProjetUtilisateur;
	}




	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		ProjetDTO proj = new ProjetDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		proj = projetService.readProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return proj;
	}

	@Override
	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		int updateCDPnum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateCDPnum = projetService.ajoutChefDeProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateCDPnum;
	}

	@Override
	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		int createNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = projetService.createProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;
	}

	@Override
	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		int updateNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = projetService.updateProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;
	}

	@Override
	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		int deleteNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = projetService.deleteProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return deleteNum;
	}

	@Override
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, ServiceException {
		
		List<StatutProjetDTO> listStatutProjet = new ArrayList<StatutProjetDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listStatutProjet = projetService.readAllStatutProjet();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listStatutProjet;
	}

	@Override
	public int addProjetUtil(UtilisateurDTO utilisateur, ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		
       int addNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		addNum = projetService.addProjetUtil(utilisateur, projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return addNum;
	}
	

	@Override
	public int updateProjetUtil(UtilisateurDTO utilisateur, ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		 
		int updateNum=0;
			
			if (caller == null) {
				beginTransactionalConnexion();
			} else {
				putInTransaction(caller);
			}
			updateNum = projetService.updateProjetUtil(utilisateur, projet);
			if (caller == null) {
				endTransactionalConnexion();
			} else {
				putOffTransaction();
			}
			
			return updateNum;
		}
		
	

	@Override
	public int deleteProjetUtil(UtilisateurDTO utilisateur, ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		
		int deleteNum=0;
			
			if (caller == null) {
				beginTransactionalConnexion();
			} else {
				putInTransaction(caller);
			}
			deleteNum = projetService.deleteProjetUtil(utilisateur, projet);
			if (caller == null) {
				endTransactionalConnexion();
			} else {
				putOffTransaction();
			}
			
			return deleteNum;
		}

	@Override
	public List<InvitationDTO> readAllInvitation(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
	
		List<InvitationDTO> listAllInvitation = new ArrayList<InvitationDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listAllInvitation = projetService.readAllInvitation(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listAllInvitation;
	}
		
	}




