package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;
import com.beyondfootsteps.beyondfootsteps.services.AsylumRequestService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AsylumRequestResolver {

    private final AsylumRequestService asylumRequestService;

    @QueryMapping(name = "asylumRequests")
    public List<AsylumRequest> findAll() {
        return asylumRequestService.findAll();
    }

}
