package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProfilDTO;
import fr.imie.formation.services.interfaces.IProfilService;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProfilServiceProxy implements IProfilService{

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putOffTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTransactionalConnexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfilDTO> readAllProfil()
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
