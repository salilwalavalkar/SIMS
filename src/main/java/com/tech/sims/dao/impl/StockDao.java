package com.tech.sims.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.tech.sims.dao.base.AbstractDaoImpl;
import com.tech.sims.dao.entity.StockEVO;
import com.tech.sims.dao.intf.IStockDao;

/**
 * StockDao Implementation
 * 
 * @author shailendra.
 * @version 1.0
 */
public class StockDao extends AbstractDaoImpl implements IStockDao {

	/**
	 * This method is use to add a stock with the help of hibernate.
	 * 
	 * @param evo
	 */
	@Override
	public void addStock(StockEVO evo) {
		hibernateTemplate.save(evo);
	}

	/**
	 * This method is use to edit a stock with the help of hibernate. it is
	 * passing a symbol on the basis of this it will search.
	 */
	@Override
	public StockEVO retrieveStock(String symbol) {
		return hibernateTemplate.get(StockEVO.class, symbol);
	}

	/**
	 * This method is use to save a stock with the help of hibernate.
	 */
	@Override
	public void saveStock(StockEVO evo) {
		hibernateTemplate.update(evo);

	}

	@Override
	public List<StockEVO> getStockList(final Map<String, Object> parameterMap) {

		List<StockEVO> finalReturnList = null;
		finalReturnList = hibernateTemplate
				.execute(new HibernateCallback<List<StockEVO>>() {
					/**
					 * Execute defined query in Hibernate.
					 * 
					 * @throws HibernateException
					 *             - in case of Hibernate errors .
					 * @throws SQLException
					 *             - in case of errors on direct JDBC access.
					 */
					public List<StockEVO> doInHibernate(final Session session)
							throws HibernateException, SQLException {

						Query query = session.createQuery(constructQuery(parameterMap));
						updateQueryParameters(query, parameterMap);
						@SuppressWarnings("unchecked")
						List<StockEVO> list = query.list();
						return list;
					}
				});
		return finalReturnList;
	}
	
	private String constructQuery(final Map<String, Object> parameterMap)
	{
		StringBuilder tempQuery = new StringBuilder(" From StockEVO stk where 1=1 ");
		if(parameterMap.containsKey("symbol"))
		{
			tempQuery.append(" and stk.symbol =:symbol ");
		}
		if(parameterMap.containsKey("name"))
		{
			tempQuery.append(" and stk.name =:name ");
		}
		if(parameterMap.containsKey("currentMktPriceMin"))
		{
			tempQuery.append(" and stk.currentMktPrice >= :currentMktPriceMin");
		}		
		if(parameterMap.containsKey("currentMktPriceMax"))
		{
			tempQuery.append(" and stk.currentMktPrice <= :currentMktPriceMax");
		}		
		return tempQuery.toString();
	}
	
	private void updateQueryParameters(final Query query, final Map<String, Object> parameterMap)
	{
		if(parameterMap.containsKey("symbol"))
		{
			query.setString("symbol", String.valueOf(parameterMap.get("symbol")));
		}
		if(parameterMap.containsKey("name"))
		{
			query.setString("name", String.valueOf(parameterMap.get("name")));
		}
		if(parameterMap.containsKey("currentMktPriceMin"))
		{
			query.setDouble("currentMktPriceMin", (Double)(parameterMap.get("currentMktPriceMin")));
		}
		if(parameterMap.containsKey("currentMktPriceMax"))
		{
			query.setDouble("currentMktPriceMax", (Double)(parameterMap.get("currentMktPriceMax")));
		}		
	}
}
