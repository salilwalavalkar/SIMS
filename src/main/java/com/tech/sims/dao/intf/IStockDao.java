package com.tech.sims.dao.intf;

import java.util.List;
import java.util.Map;

import com.tech.sims.dao.base.IDao;
import com.tech.sims.dao.entity.StockEVO;

/**
 * Interface definition for StockDao.
 * 
 * @author shailendra.
 * @version 1.0
 */
public interface IStockDao extends IDao {

	/**
	 * 
	 * method description for adding a stock.passing a evo
	 * 
	 * @param evo
	 */
	void addStock(final StockEVO evo);

	/**
	 * method description for saving a stock .passing a evo
	 * 
	 * @param evo
	 */
	void saveStock(final StockEVO evo);

	/**
	 * method description for edit a stock.passing a symbol
	 * 
	 * @param symbol
	 * @return stock
	 */
	StockEVO retrieveStock(final String symbol);


	/**
	 * method description for searing a stock.In this passing a map storing all
	 * the data from the database.
	 * 
	 * @param parameterMap
	 * @return List <StockEVO>
	 */
	List<StockEVO> getStockList(final Map<String, Object> parameterMap);	

}
