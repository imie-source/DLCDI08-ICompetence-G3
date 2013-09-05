package fr.imie.formation;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class LauncherCompetence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		CompetenceDTO competenceDTO = new CompetenceDTO();
		competenceDTO.setNum(8);
		CompetenceDTO comp = new CompetenceDTO();
		
		IDAOFactory idaoFactory = DAOFactory1.getInstance();
		try {
			comp = idaoFactory.createCompetenceNiveauService(null).readCompetence(competenceDTO);
		} catch (TransactionalConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(comp.getNom());
		System.out.println(comp.getNum());
		System.out.println(comp.getCompetenceDomaine().getNum());
		System.out.println(comp.getCompetenceDomaine().getNom());
		System.out.println(comp.getListCompetence().get(0));
		System.out.println(comp.getListCompetence().get(1));
		*/
		
		
		List<CompetenceDTO> listComp = new ArrayList<CompetenceDTO>();
		IDAOFactory idaoFactory = DAOFactory1.getInstance();
		
		try {
			listComp = idaoFactory.createCompetenceNiveauService(null).readAllCompetence();
		} catch (TransactionalConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < listComp.size(); i++) {
			System.out.println(listComp.get(i).getNum());
			System.out.println(listComp.get(i).getNom());
		}
		
	}

}
