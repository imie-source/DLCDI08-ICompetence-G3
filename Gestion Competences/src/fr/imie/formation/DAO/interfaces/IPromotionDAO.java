package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IPromotionDAO extends ITransactional {

	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, DAOException;
	
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException ;
	
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException;
	
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException;
	
	public PromotionDTO readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException;

}
