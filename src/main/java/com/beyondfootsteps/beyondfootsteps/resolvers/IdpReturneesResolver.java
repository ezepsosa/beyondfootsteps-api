package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;
import com.beyondfootsteps.beyondfootsteps.services.IdpReturneesService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IdpReturneesResolver {

    private final IdpReturneesService idpReturneesService;

    @QueryMapping(name = "idpReturnees")
    public List<IdpReturnees> findAll() {
        return idpReturneesService.findAll();
    }

}
