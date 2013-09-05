package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IProjetService extends ITransactional{
	
	//PROJET
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, DAOException;

	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;
	
	public List<ProjetDTO> readProjetByUtilisateur()
	throws TransactionalConnectionException, DAOException;

	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;
	
	//STATUT PROJET
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, DAOException;
}
