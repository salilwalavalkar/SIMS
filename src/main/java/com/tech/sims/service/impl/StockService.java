package com.tech.sims.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hsqldb.persist.LockFile.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.sims.dao.entity.StockEVO;
import com.tech.sims.dao.intf.IStockDao;
import com.tech.sims.model.StockDetails;
import com.tech.sims.service.intf.IStockService;

/**
 * Stock service implementation for STockDetails which extends
 * AbstractController
 * 
 * @author salil.
 * @version 1.0
 */
public class StockService implements IStockService {

	@Autowired
	private IStockDao stockDao;

	/**
	 * This method is use to add a stock.It is used to add the details by
	 * using stockdao add method and store it in evo
	 * 
	 * @param - model
	 * @return - add a stock 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = BaseException.class)
	public void addStock(StockDetails model) {
		StockEVO evo = convertToEVO(new StockEVO(), model);
		stockDao.addStock(evo);

	}

	private StockEVO convertToEVO(StockEVO stockEVO, StockDetails model) {
		stockEVO.setCompanyName(model.getCompanyName());
		stockEVO.setCurrentMktPrice(model.getCurrentMktPrice());
		stockEVO.setDescription(model.getDescription());
		stockEVO.setName(model.getName());
		stockEVO.setQuantity(model.getQuantity());
		stockEVO.setSymbol(model.getSymbol());
		return stockEVO;
	}

	/**
	 * This method is use to edit a stock and getting the values from the evo
	 * and set these values into model.
	 * 
	 * @param - model
	 * @return - convertToModel
	 */
	@Override
	public StockDetails retrieveStock(String symbol) {
		return convertToModel(stockDao.retrieveStock(symbol));

	}

	private StockDetails convertToModel(StockEVO evo) {
		if (evo == null) {
			return null;
		}
		StockDetails model = new StockDetails();
		model.setCompanyName(evo.getCompanyName());
		model.setCurrentMktPrice(evo.getCurrentMktPrice());
		model.setDescription(evo.getDescription());
		model.setName(evo.getName());
		model.setQuantity(evo.getQuantity());
		model.setSymbol(evo.getSymbol());
		return model;
	}

	/**
	 * This method is use to save a stock.It is used to save the details by
	 * using stockdao method and store it in evo
	 * 
	 * 
	 * @param - model
	 * @return - convertToEVO
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = BaseException.class)
	public void saveStockDetails(StockDetails stockDetails) {
		StockEVO evo = convertToEVO(new StockEVO(), stockDetails);
		stockDao.saveStock(evo);

	}

	/****************************** Search Function *******************************************/
	/**
	 * This method is used for searching a stock.
	 * 
	 * @param - parameterMap
	 * @return - convertToModelList
	 * @throws BaseException 
	 */
	@Override
	public List<StockDetails> retrieveStockDetailsList(
			Map<String, Object> parameterMap) {

		return convertToModelList(stockDao.getStockList(parameterMap));
	}

	private List<StockDetails> convertToModelList(
			List<StockEVO> retrieveStockDetailsList) {
		List<StockDetails> stockDetails = null;
		if (!retrieveStockDetailsList.isEmpty()) {
			stockDetails = new ArrayList<StockDetails>();
			for (StockEVO evo : retrieveStockDetailsList) {
				StockDetails model = new StockDetails();
				model.setCurrentMktPrice(evo.getCurrentMktPrice());
				model.setCompanyName(evo.getCompanyName());
				model.setDescription(evo.getDescription());
				model.setName(evo.getName());
				model.setQuantity(evo.getQuantity());
				model.setSymbol(evo.getSymbol());
				model.setQuantity(evo.getQuantity());
				stockDetails.add(model);
			}
		}
		return stockDetails;
	}
}