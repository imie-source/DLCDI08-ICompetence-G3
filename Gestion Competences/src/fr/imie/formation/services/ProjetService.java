package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.interfaces.IProjetService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProjetService extends ATransactional implements IProjetService{

	//PROJET
	@Override
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, DAOException {
		
		List<ProjetDTO> listProjet = new ArrayList<ProjetDTO>();
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		listProjet = iDaoFactory.createIProjetDAO(this).readAllProjets();
		return listProjet;
	}

	@Override
	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//STATUT PROJET
	@Override
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
