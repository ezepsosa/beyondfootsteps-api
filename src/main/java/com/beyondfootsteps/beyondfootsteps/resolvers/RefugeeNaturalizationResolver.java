package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;
import com.beyondfootsteps.beyondfootsteps.services.RefugeeNaturalizationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RefugeeNaturalizationResolver {

    private final RefugeeNaturalizationService refugeeNaturalizationService;

    @QueryMapping(name = "refugeeNaturalizations")
    public List<RefugeeNaturalization> findAll() {
        return refugeeNaturalizationService.findAll();
    }

    @QueryMapping(name = "refugeeNaturalizationsByYearAndCountry")
    public List<RefugeeNaturalization> findByYearAndCountry(@Argument int year, @Argument String countryOfOriginIso,
            @Argument String countryOfAsylumIso) {
        return refugeeNaturalizationService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);

    }

}
