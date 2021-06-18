package com.interview.task.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ServeAdDetailsRequestModel;

public interface CampaignService {
	public ResponseEntity<Object> addCampaign(CampaignDetailsRequestModel campaignDetails);
	public Product serveAd(ServeAdDetailsRequestModel serveAdDetails);

}
