package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface ICompetenceDAO extends ITransactional {

	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, DAOException;
	
	public CompetenceDTO readCompetence(CompetenceDTO competenceDTO)
			throws TransactionalConnectionException, DAOException;

}
