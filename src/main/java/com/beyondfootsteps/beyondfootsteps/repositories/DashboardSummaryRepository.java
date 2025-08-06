package com.beyondfootsteps.beyondfootsteps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;

@Repository
public interface DashboardSummaryRepository extends JpaRepository<DashboardSummary, String>{

    List<DashboardSummary> findByYear(int year);

}
