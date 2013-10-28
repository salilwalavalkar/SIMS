package com.tech.sims.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tech.sims.form.stock.StockForm;
import com.tech.sims.model.StockDetails;
import com.tech.sims.service.intf.IStockService;

/**
 * StockController for all stock operations
 * 
 * @author salil.
 * @version 1.0
 */
@Controller
@RequestMapping("/stock/*")
public class StockController{

	@Autowired
	private IStockService stockService;

	private static final String VIEW_PREFIX = "stock";

	/**
	 * This method is used to show the home page. Get data to load on home page.
	 * Store the value in form
	 * 
	 * @param HttpServletRequest
	 *            - request object
	 * @param HttpServletResponse
	 *            - response object
	 * @return ModelAndView to load on UI
	 */
	@RequestMapping(method = RequestMethod.GET, value = "homePage")
	public ModelAndView showHomePage(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/homePage");
		view.addObject("stockForm", new StockForm());
		return view;
	}

	/**
	 * This method is used to add a stock.Get the data to load from UI and add
	 * it in the database
	 * 
	 * @param HttpServletRequest
	 *            - request object
	 * @param HttpServletResponse
	 *            - response object
	 * @return ModelAndView - view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "showAddStockDetails")
	public ModelAndView showAddStockScreen(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/showAddStockDetails");
		view.addObject("stockForm", new StockForm());
		return view;
	}

	private StockDetails convertToModel(StockForm form) {
		StockDetails model = new StockDetails();
		model.setSymbol(form.getSymbol());
		model.setName(form.getName());
		model.setCompanyName(form.getCompanyName());
		model.setDescription(form.getDescription());
		model.setQuantity(Integer.parseInt(form.getQuantity()));
		model.setCurrentMktPrice(Double.parseDouble(form.getCurrentMktPrice()));
		return model;
	}
	
	/**
	 * This method is used to add a stock details. Add the details on jsp and it
	 * will add it to the database.
	 * 
	 * @param HttpServletRequest
	 *            - request
	 * @param HttpServletResponse
	 *            - response
	 * @param stockForm
	 *            - form
	 * @return ModelAndView - view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "addStockDetails")
	public ModelAndView addStockDetails(final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("stockForm") StockForm stockForm) {
		stockService.addStock(convertToModel(stockForm));
		return showHomePage(request, response);
	}

	@RequestMapping(method = RequestMethod.POST, value = "searchStockForEdit")
	public ModelAndView searchStockForEdit(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/searchStockForEdit");
		view.addObject("stockForm", new StockForm());
		
		String stkFound = (String)request.getAttribute("STOCK_FOUND");
		if(stkFound!= null && stkFound.equalsIgnoreCase("NO"))
		{
			view.addObject("stkFound", false);
			request.removeAttribute("STOCK_FOUND");
		}
	
		return view;
	}

	@RequestMapping(method = RequestMethod.POST, value = "searchAndLoadStockDetails")
	public ModelAndView searchAndLoadStockDetails(final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("stockForm") StockForm stockForm) {
		StockDetails stockDetails = stockService.retrieveStock(stockForm.getSymbol());
		if(stockDetails == null)
		{
			request.setAttribute("STOCK_FOUND", "NO");
			return searchStockForEdit(request, response);
		}
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/showEditStockDetails");
		view.addObject("stockForm", new StockForm());
		view.addObject("stockDetails", stockDetails);
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "saveStockDetails")
	public ModelAndView saveStockDetails(final HttpServletRequest request,
			final HttpServletResponse response, @ModelAttribute("stockForm") StockForm stockForm) {
		stockService.saveStockDetails(convertToModel(stockForm));
		return showHomePage(request, response);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "detailedSearchCriteria")
	public ModelAndView detailedSearchCriteria(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/detailedSearchCriteria");
		view.addObject("stockForm", new StockForm());		
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "detailedSearchResults")
	public ModelAndView detailedSearchResults(final HttpServletRequest request,
			final HttpServletResponse response, 
			@ModelAttribute("stockForm") StockForm stockForm) {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/detailedSearchResults");
		List<StockDetails> stockDetailsList = stockService.retrieveStockDetailsList(createParametersMap(stockForm));
		view.addObject("stockDetailsList", stockDetailsList);
		view.addObject("stockForm", new StockForm());
		return view;
	}
	
	private Map<String, Object> createParametersMap(final StockForm stockForm)
	{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		if(!isEmptyOrBlank(stockForm.getSymbol()))
		{
			parameterMap.put("symbol", stockForm.getSymbol().trim());
		}
		if(!isEmptyOrBlank(stockForm.getName()))
		{
			parameterMap.put("name", stockForm.getName().trim());
		}
		if(!isEmptyOrBlank(stockForm.getCurrentMktPriceMin()))
		{
			parameterMap.put("currentMktPriceMin", Double.parseDouble(stockForm.getCurrentMktPriceMin().trim()));
		}
		if(!isEmptyOrBlank(stockForm.getCurrentMktPriceMax()))
		{
			parameterMap.put("currentMktPriceMax", Double.parseDouble(stockForm.getCurrentMktPriceMax().trim()));
		}		
		return parameterMap;
	}
	
    protected boolean isEmptyOrBlank(final String str) {
        return (str == null) || str.trim().isEmpty();
    }
}


