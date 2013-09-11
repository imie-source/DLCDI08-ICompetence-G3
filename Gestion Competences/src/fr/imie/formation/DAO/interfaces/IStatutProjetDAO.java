package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IStatutProjetDAO extends ITransactional{

	public List<StatutProjetDTO> readAllStatutProjet()
		throws TransactionalConnectionException, DAOException;
	
	public int updateStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException;
	
	public int createStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException;
	
	public int deleteStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException;

}