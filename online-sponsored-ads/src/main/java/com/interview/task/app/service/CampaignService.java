package com.interview.task.app.service;

import com.interview.task.app.model.entity.Campaign;
import com.interview.task.app.model.entity.Product;
import com.interview.task.app.model.request.CampaignDetailsRequestModel;
import com.interview.task.app.model.request.ServeAdDetailsRequestModel;

public interface CampaignService {
	public Campaign addCampaign(CampaignDetailsRequestModel campaignDetails);
	public Product serveAd(ServeAdDetailsRequestModel serveAdDetails);

}
