package fr.imie.formation.DAO.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.NiveauDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.INiveauDAO;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class NiveauProxy implements INiveauDAO {

	NiveauDAO niveauDAO;
	ITransactional caller = null;

	public NiveauProxy(NiveauDAO niveauDAO, ITransactional caller) {
		super();
		this.caller = caller;
		this.niveauDAO = niveauDAO;
	}

	public NiveauProxy(NiveauDAO niveauDAO) {

		this.niveauDAO = niveauDAO;
	}

	@Override
	public Connection getConnection() {

		return niveauDAO.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		niveauDAO.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		niveauDAO.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {
		niveauDAO.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {
		niveauDAO.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		niveauDAO.beginTransactionalConnexion();

	}

	@Override
	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, DAOException {

		List<NiveauDTO> listeNiveau = new ArrayList<NiveauDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNiveau = niveauDAO.readCompetenceNiveauUtilisateur(utilisateurDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNiveau;
	}

	@Override
	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competenceDTO)
			throws TransactionalConnectionException, DAOException {

		List<NiveauDTO> listeNiveau = new ArrayList<NiveauDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNiveau = niveauDAO.readNiveauUtilisateurCompetence(competenceDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNiveau;
	}


	public int addCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			DAOException {
		int addNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		addNum = niveauDAO.addCompUtil( utilisateur,comp,niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return addNum;
		
	}

	
	public int updateCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			DAOException {
		int updateNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = niveauDAO.updateCompUtil(utilisateur, comp, niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return updateNum;
	}

	
	public int deleteCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			DAOException {
		int deleteNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = niveauDAO.deleteCompUtil( utilisateur,comp,niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return deleteNum;
	}

	@Override
	public List<NiveauDTO> readAllNomNiveau(NiveauDTO niveau)
			throws TransactionalConnectionException, DAOException {
		
		List<NiveauDTO> listeNomNiveau = new ArrayList<NiveauDTO>();
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNomNiveau = niveauDAO.readAllNomNiveau(niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNomNiveau;
	}
	}


