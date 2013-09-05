package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.UtilisateurService;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class UtilisateurServiceProxy implements IUtilisateurService {

	private UtilisateurService utilisateurService;

	ITransactional caller = null;

	public UtilisateurServiceProxy(UtilisateurService utilisateurService,
			ITransactional caller) {
		super();
		this.utilisateurService = utilisateurService;
		this.caller = caller;
	}

	@Override
	public Connection getConnection() {

		return utilisateurService.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {

		utilisateurService.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {

		utilisateurService.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {

		utilisateurService.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {

		utilisateurService.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {

		utilisateurService.beginTransactionalConnexion();

	}

	@Override
	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, ServiceException {

		List<UtilisateurDTO> listeUtilisateur = new ArrayList<UtilisateurDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeUtilisateur = utilisateurService.readAllUtilisateur();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeUtilisateur;
	}

	@Override
	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		UtilisateurDTO utilisateur = new UtilisateurDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		utilisateur = utilisateurService.readUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return utilisateur;
	}

	@Override
	public int createUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int createNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = utilisateurService.createUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;
	}

	@Override
	public int updateUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int updateNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = utilisateurService.updateUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;

	}

	@Override
	public int deleteUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {

		int deleteNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = utilisateurService.deleteUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return deleteNum;

	}

	@Override
	public boolean logUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException {
		
		boolean logExist = false;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		logExist = utilisateurService.logUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return logExist;
	}

	@Override
	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException {
		List<UtilisateurDTO> listUtilProjet = new ArrayList<UtilisateurDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listUtilProjet = utilisateurService.readUtilisateurProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listUtilProjet;
	}

}
