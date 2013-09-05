package fr.imie.formation.DAO.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.ProjetDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IProjetDAO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProjetProxy implements IProjetDAO {

	ProjetDAO projetDAO;
	ITransactional caller = null;

	public ProjetProxy(ProjetDAO projetDAO, ITransactional caller){
		super();
		this.caller = caller;
		this.projetDAO = projetDAO;
	}

	public ProjetProxy(ProjetDAO projetDAO){
		this.projetDAO = projetDAO;
	}

	@Override
	public Connection getConnection() {

		return projetDAO.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		projetDAO.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		projetDAO.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {
		projetDAO.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {
		projetDAO.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		projetDAO.beginTransactionalConnexion();

	}

	@Override
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, DAOException {

		List<ProjetDTO> listProjet = new ArrayList<ProjetDTO>();
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listProjet = projetDAO.readAllProjets();
		if (caller == null){
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listProjet;
	}

	@Override
	public List<ProjetDTO> readProjetByUtilisateur()
			throws TransactionalConnectionException, DAOException {

		List<ProjetDTO>listeProjetUtilisateur=new ArrayList<ProjetDTO>();

		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeProjetUtilisateur=projetDAO.readProjetByUtilisateur();
		if (caller == null){
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeProjetUtilisateur;
	}


	@Override
	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {

		ProjetDTO proj = new ProjetDTO();
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		proj = projetDAO.readProjet(projet);
		if (caller == null){
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return proj;
	}

	@Override
	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {

		int updateCDPNum = 0;
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateCDPNum = projetDAO.ajoutChefDeProjet(projet);
		if (caller == null){
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateCDPNum;
	}

	@Override
	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {

		int createNum = 0;
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = projetDAO.createProjet(projet);
		if (caller == null){
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
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = projetDAO.updateProjet(projet);
		if (caller == null){
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
		if (caller == null){
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = projetDAO.deleteProjet(projet);
		if (caller == null){
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return deleteNum;
	}





}
