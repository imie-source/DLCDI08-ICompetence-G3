package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IProjetDAO extends ITransactional{

	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, DAOException;

	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;
	
	public List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur)
	throws TransactionalConnectionException, DAOException;

}