package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.services.DashboardSummaryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DashboardSummaryResolver {

    private final DashboardSummaryService dashboardSummaryService;

    @QueryMapping(name = "dashboardSummaries")
    public List<DashboardSummary> findAll() {
        return dashboardSummaryService.findAll();
    }

    @QueryMapping(name = "dashboardSummariesByYear")
    public List<DashboardSummary> findByYear(@Argument int year){
        return dashboardSummaryService.findByYear(year);
    }

}
