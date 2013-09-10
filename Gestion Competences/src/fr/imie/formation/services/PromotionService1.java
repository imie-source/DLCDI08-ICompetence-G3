package fr.imie.formation.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class PromotionService1 extends ATransactional implements
		IPromotionService {

	public PromotionService1() {
		super();
	}

	// PROMOTION

	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, ServiceException {

		List<PromotionDTO> listPromo = new ArrayList<PromotionDTO>();
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listPromo = iDaoFactory.createIPromotionDAO(this)
					.readAllPromotion();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPromo;
	}
	
	public List<PromotionDTO> readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		List<PromotionDTO> listPromotion = new ArrayList<PromotionDTO>();
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			listPromotion = iDaoFactory.createIPromotionDAO(this)
					.readPromotion(promo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPromotion;
	}
	
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		int createNum = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			createNum = iDaoFactory.createIPromotionDAO(this).createPromotion(
					promo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createNum;
}
	
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		int deleteNum = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			deleteNum = iDaoFactory.createIPromotionDAO(this).deletePromotion(
					promo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteNum;
}
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		int updateNum = 0;
		
		IDAOFactory iDaoFactory = DAOFactory1.getInstance();
		try {
			updateNum = iDaoFactory.createIPromotionDAO(this).updatePromotion(
					promo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateNum;
}	
}