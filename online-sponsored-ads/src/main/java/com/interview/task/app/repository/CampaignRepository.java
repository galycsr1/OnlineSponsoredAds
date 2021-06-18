package com.interview.task.app.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.interview.task.app.model.entity.Campaign;
@Repository
public interface CampaignRepository extends CrudRepository<Campaign, UUID>{
	
	@Query(value = "SELECT max(c.bid) FROM Campaign c WHERE c.startDate >= :startDate and c.category = :category")
	BigDecimal findMaxBidByCategoryAndStartDate(@Param("startDate") Date startDate, @Param("category") String category);
	
	@Query(value = "SELECT c FROM Campaign c WHERE c.bid = :bid and c.startDate >= :startDate and c.category = :category")
	List<Campaign> findCampaignByBidAndCategoryAndStartDate(@Param("bid") BigDecimal bid,@Param("startDate") Date startDate, @Param("category") String category);
	
	@Query(value = "SELECT c FROM Campaign c WHERE c.startDate >= :startDate")
	List<Campaign> findCampaignByStartDate(@Param("startDate") Date startDate);
	
	

}
