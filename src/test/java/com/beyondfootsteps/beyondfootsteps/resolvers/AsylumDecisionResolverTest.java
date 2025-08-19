package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.services.AsylumDecisionService;

@SpringBootTest
class AsylumDecisionResolverTest {

    private AsylumDecisionService asylumDecisionService;
    private AsylumDecisionResolver asylumDecisionResolver;

    @BeforeEach
    void setUp() {
        asylumDecisionService = mock(AsylumDecisionService.class);
        asylumDecisionResolver = new AsylumDecisionResolver(asylumDecisionService);
    }

    @Test
    void shouldFindAllAsylumDecisions() {
        AsylumDecision decision = new AsylumDecision();
        decision.setId("test-id");
        when(asylumDecisionService.findAll()).thenReturn(List.of(decision));

        List<AsylumDecision> result = asylumDecisionResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldFindByYearAndCountry() {
        int year = 2025;
        String countryOfOriginIso = "AFG";
        String countryOfAsylumIso = "USA";
        AsylumDecision decision = new AsylumDecision();
        decision.setId("test-id");
        when(asylumDecisionService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenReturn(List.of(decision));

        List<AsylumDecision> result = asylumDecisionResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldThrowInvalidParamExceptionWhenFindByYearAndCountryWithInvalidCountries() {
        int year = 2025;
        String countryOfOriginIso = null;
        String countryOfAsylumIso = null;
        when(asylumDecisionService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenThrow(new InvalidParamException("At least one country must be provided"));

        InvalidParamException ex = assertThrows(InvalidParamException.class, () -> {
            asylumDecisionResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        });
        assertNotNull(ex.getMessage());
    }

}
