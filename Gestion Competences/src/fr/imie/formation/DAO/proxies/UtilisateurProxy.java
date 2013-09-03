package fr.imie.formation.DAO.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.UtilisateurDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IUtilisateurDAO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class UtilisateurProxy implements IUtilisateurDAO {

	UtilisateurDAO utilisateurDAO;
	ITransactional caller = null;

	public UtilisateurProxy(UtilisateurDAO utilisateurDAO, ITransactional caller) {
		super();
		this.caller = caller;
		this.utilisateurDAO = utilisateurDAO;
	}

	public UtilisateurProxy(UtilisateurDAO utilisateurDAO) {

		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public Connection getConnection() {

		return utilisateurDAO.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		utilisateurDAO.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		utilisateurDAO.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {
		utilisateurDAO.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {
		utilisateurDAO.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		utilisateurDAO.beginTransactionalConnexion();

	}

	@Override
	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, DAOException {

		List<UtilisateurDTO> listeUtilisateur = new ArrayList<UtilisateurDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeUtilisateur = utilisateurDAO.readAllUtilisateur();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeUtilisateur;
	}

	@Override
	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		UtilisateurDTO utilisateur = new UtilisateurDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		utilisateur = utilisateurDAO.readUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return utilisateur;
	}

	@Override
	public int createUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		int createNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = utilisateurDAO.createUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;
	}

	@Override
	public int updateUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		int updateNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = utilisateurDAO.updateUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;
	}

	@Override
	public int deleteUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		int deleteNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = utilisateurDAO.deleteUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return deleteNum;
	}

	@Override
	public boolean logUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		boolean logExist = false;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		logExist = utilisateurDAO.logUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return logExist;
	}

	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		
		List<UtilisateurDTO> listUtilProjet = new ArrayList<UtilisateurDTO>();
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listUtilProjet = utilisateurDAO.readUtilisateurProjet(projet);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listUtilProjet;
	}

}
