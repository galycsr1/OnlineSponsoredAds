package com.interview.task.app.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ServeAdDetailsRequestModel;
import com.interview.task.app.service.CampaignService;


@RestController
@RequestMapping("campaigns")
public class CampaignContoller {
	
	
		
	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody CampaignDetailsRequestModel campaignDetails) {
		return campaignService.addCampaign(campaignDetails);
	}
	
	@RequestMapping(value = {"/serveAd"}, method = RequestMethod.GET)
	public Product serveAd(@RequestBody ServeAdDetailsRequestModel serveAdDetails) {
		return campaignService.serveAd(serveAdDetails);
	}
}
