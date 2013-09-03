package fr.imie.formation.DAO.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.CompetenceDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.ICompetenceDAO;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class CompetenceProxy implements ICompetenceDAO {

	CompetenceDAO competenceDAO;
	ITransactional caller = null;

	public CompetenceProxy(CompetenceDAO competenceDAO, ITransactional caller) {
		super();
		this.caller = caller;
		this.competenceDAO = competenceDAO;
	}

	public CompetenceProxy(CompetenceDAO competenceDAO) {

		this.competenceDAO = competenceDAO;
	}

	@Override
	public Connection getConnection() {

		return competenceDAO.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		competenceDAO.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		competenceDAO.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {
		competenceDAO.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {
		competenceDAO.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		competenceDAO.beginTransactionalConnexion();

	}

	@Override
	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, DAOException {

		List<CompetenceDTO> listeCompetenceDTO = new ArrayList<CompetenceDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeCompetenceDTO = competenceDAO.readAllCompetence();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeCompetenceDTO;
	}

}
