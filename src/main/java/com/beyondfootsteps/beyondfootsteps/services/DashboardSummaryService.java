package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.DashboardSummaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardSummaryService {

    private final DashboardSummaryRepository dashboardSummaryRepository;

    public List<DashboardSummary> findAll() {
        return dashboardSummaryRepository.findAll();
    }

    public List<DashboardSummary> findByYear(int year) {
        return dashboardSummaryRepository.findByYear(year);
    }
}
