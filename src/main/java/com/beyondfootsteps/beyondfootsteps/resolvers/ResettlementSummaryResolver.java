package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.services.ResettlementSummaryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ResettlementSummaryResolver {

    private final ResettlementSummaryService resettlementSummaryService;

    @QueryMapping(name = "resettlementSummaries")
    public List<ResettlementSummary> findAll() {
        return resettlementSummaryService.findAll();
    }

    @QueryMapping(name = "resettlementSummariesByYearGroupedBy")
    public List<ResettlementSummaryOriginGroupedResponse> findByYearGroupedBy(@Argument int year, @Argument String grouping) {
        return resettlementSummaryService.findByYearGroupedBy(year, grouping);
    }

    @QueryMapping(name = "resettlementSummariesGroupedByAsylumYear")
    public List<ResettlementSummaryOriginGroupedYearResponse> findGroupedByYear() {
        return resettlementSummaryService.findGroupedByYear();
    }

}
