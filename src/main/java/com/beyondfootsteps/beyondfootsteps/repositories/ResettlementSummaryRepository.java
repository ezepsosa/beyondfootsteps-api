package com.beyondfootsteps.beyondfootsteps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;

@Repository
public interface ResettlementSummaryRepository extends JpaRepository<ResettlementSummary, String>{

}
