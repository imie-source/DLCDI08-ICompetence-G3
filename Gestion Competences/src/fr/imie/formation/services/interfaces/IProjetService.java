package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IProjetService extends ITransactional{
	
	//PROJET
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, ServiceException;

	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;
	
	//STATUT PROJET
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, ServiceException;
}
