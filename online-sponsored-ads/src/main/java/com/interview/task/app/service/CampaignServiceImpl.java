package com.interview.task.app.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interview.task.app.model.entity.Campaign;
import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ProductDetailsRequestModel;
import com.interview.task.app.model.request.ServeAdDetailsRequestModel;
import com.interview.task.app.repository.CampaignRepository;
@Service
public class CampaignServiceImpl implements CampaignService{
	@Autowired
	CampaignRepository campaignRepository;
	
	@Autowired
	ProductService productService;
	
	@Transactional
    public ResponseEntity<Object> addCampaign(CampaignDetailsRequestModel campaignDetails)  {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(campaignDetails.getStartDate());
		List<Product> products = productService.getProductByCategory(campaignDetails.getCategory());
		Campaign campaign = new Campaign(UUID.randomUUID(), campaignDetails.getName(), campaignDetails.getStartDate(), campaignDetails.getCategory(), campaignDetails.getBid(), products);
		campaignRepository.save(campaign);
		if(!campaignRepository.existsById(campaign.getId())) {
			return ResponseEntity.unprocessableEntity().body("Campaign Creation Failed");
	
    	}else{
     		return ResponseEntity.unprocessableEntity().body("Campaign Creation Succsess");
     	}
		
	}
	
	@Transactional
    public Product serveAd(ServeAdDetailsRequestModel serveAdDetails){
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -10);
        Date startDate = cal.getTime();   
        System.out.println(serveAdDetails.getCategory());
		BigDecimal bid = campaignRepository.findMaxBidByCategoryAndStartDate(startDate, serveAdDetails.getCategory());
		System.out.println("******************************************");
		System.out.println(bid);
		if(bid!=null) {
			List<Campaign> campaigns = campaignRepository.findCampaignByBidAndCategoryAndStartDate(bid, startDate, serveAdDetails.getCategory());
			System.out.println(campaigns.get(0));
			return campaigns.get(0).getProducts().get(0);
		}
		else {
			List<Campaign> campaigns = campaignRepository.findCampaignByStartDate(startDate);
			BigDecimal max_bid = BigDecimal.ZERO;
			Campaign maxCampaign = null;
			
			for(Campaign campaign :campaigns) {
				if(campaign.getBid().compareTo(max_bid)>0)
					maxCampaign=campaign;
				
			}
			if(maxCampaign!=null)
				return maxCampaign.getProducts().get(0);
			return null;
		}
		
		
	}

}
