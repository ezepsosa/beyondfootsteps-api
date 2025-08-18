package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.DashboardSummaryRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing dashboard data
 */
@Service
@RequiredArgsConstructor
public class DashboardSummaryService {

    private final DashboardSummaryRepository dashboardSummaryRepository;

    private static final Logger logger = Logger.getLogger(DashboardSummaryService.class.getName());

    /**
     * Retrieves all dashboard data from the repository.
     *
     * @return a list of dashboard data
     */
    public List<DashboardSummary> findAll() {
        logger.info("Finding all dashboard data");
        return dashboardSummaryRepository.findAll();
    }

    /**
     * Retrieves dashboard data filtered by year
     *
     * @param year the year of the dashboard data
     * @return a list of dashboard data matching the criteria
     */
    public List<DashboardSummary> findByYear(int year) {
        return dashboardSummaryRepository.findByYear(year);
    }
}
