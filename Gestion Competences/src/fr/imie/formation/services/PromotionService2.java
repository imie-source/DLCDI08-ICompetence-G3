package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class PromotionService2 extends PromotionService1 implements
		IPromotionService {

	public PromotionService2() {
		super();
	}

	// PROMOTION

	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, ServiceException {

		List<PromotionDTO> listPromotion = new ArrayList<PromotionDTO>();
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listPromotion = iDaoFactory.createIPromotionDAO(this)
					.readAllPromotion();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPromotion;
	}
}
