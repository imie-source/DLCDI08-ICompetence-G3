package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.services.ProjetService;
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
			throws TransactionalConnectionException, DAOException {
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
	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
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
			throws TransactionalConnectionException, DAOException {
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
			throws TransactionalConnectionException, DAOException {
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
			throws TransactionalConnectionException, DAOException {
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
			throws TransactionalConnectionException, DAOException {
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
			throws TransactionalConnectionException, DAOException {
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
	

}
