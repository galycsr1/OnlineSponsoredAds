package com.interview.task.app.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.task.app.exception.CreationFailedException;
import com.interview.task.app.exception.ResourceNotFoundException;
import com.interview.task.app.model.entity.Campaign;
import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ServeAdDetailsRequestModel;
import com.interview.task.app.repository.CampaignRepository;
import com.interview.task.app.service.CampaignService;
import com.interview.task.app.service.ProductService;
@Service
public class CampaignServiceImpl implements CampaignService{
	@Autowired
	CampaignRepository campaignRepository;
	
	@Autowired
	ProductService productService;
	
	@Transactional
    public Campaign addCampaign(CampaignDetailsRequestModel campaignDetails)  {
		List<Product> products = productService.getProductByCategory(campaignDetails.getCategory());
		Campaign campaign = new Campaign(UUID.randomUUID(), campaignDetails.getName(), campaignDetails.getStartDate(), campaignDetails.getCategory(), campaignDetails.getBid(), products);
		campaignRepository.save(campaign);
		
		if(!campaignRepository.existsById(campaign.getId())) {
			throw new CreationFailedException("Campaign Creation Succsess");			
		}
		return campaignRepository.findById(campaign.getId()).get();
		
	}
	
	@Transactional
    public Product serveAd(ServeAdDetailsRequestModel serveAdDetails){
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -10);
        Date startDate = cal.getTime();   
        System.out.println(serveAdDetails.getCategory());
        List<Campaign> campaigns = campaignRepository.findCampaignByCategoryAndStartDateOrderByBid(startDate, serveAdDetails.getCategory());		
		if(!campaigns.isEmpty()) {
			
			return campaigns.get(0).getProducts().get(campaigns.get(0).getProducts().size()-1);
		}
		campaigns = campaignRepository.findCampaignByStartDateOrderByBid(startDate);
		if(!campaigns.isEmpty()) {
			System.out.println(campaigns);
			return campaigns.get(0).getProducts().get(campaigns.get(0).getProducts().size()-1);
		}
		throw new ResourceNotFoundException("No active campaigns in db");		
		
	}

}
