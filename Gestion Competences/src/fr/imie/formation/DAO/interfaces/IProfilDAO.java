package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProfilDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IProfilDAO extends ITransactional{

	
	public List<ProfilDTO> readAllProfil()
			throws TransactionalConnectionException, DAOException;

}
