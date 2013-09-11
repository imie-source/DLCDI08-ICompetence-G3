package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IPromotionService extends ITransactional {

	// PROMOTION

	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, ServiceException;
	
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException;
	
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException;
	
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException;
	
	public PromotionDTO readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException;
	
}
