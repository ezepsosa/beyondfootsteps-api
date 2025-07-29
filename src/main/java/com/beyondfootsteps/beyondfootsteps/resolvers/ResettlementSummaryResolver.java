package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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

}
