package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.services.AsylumDecisionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AsylumDecisionResolver {

    private final AsylumDecisionService asylumDecisionService;

    @QueryMapping(name = "asylumDecisions")
    public List<AsylumDecision> findAll() {
        return asylumDecisionService.findAll();
    }
}
