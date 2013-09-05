package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DTO.ProfilDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IProfilService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProfilService extends ATransactional implements IProfilService{

	@Override
	public List<ProfilDTO> readAllProfil()
			throws TransactionalConnectionException, ServiceException {
		
		List<ProfilDTO> listProfil = new ArrayList<ProfilDTO>();
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		listProfil = iDaoFactory.createProfilService(this)
				.readAllProfil();

		return listProfil;
	}
 
}
