package com.tech.sims.service.intf;

import java.util.List;
import java.util.Map;

import com.tech.sims.model.StockDetails;
import com.tech.sims.service.base.IService;

public interface IStockService extends IService {

	void addStock(final StockDetails model);
	
	void saveStockDetails(StockDetails stockDetails);
	
	StockDetails retrieveStock(final String symbol);
	
	List<StockDetails> retrieveStockDetailsList(Map<String, Object> parameterMap);

}
