package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.services.IdpDisplacementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IdpDisplacementResolver {

    private final IdpDisplacementService idpDisplacementService;

    @QueryMapping(name = "idpDisplacements")
    public List<IdpDisplacement> findAll() {
        return idpDisplacementService.findAll();
    }

}
