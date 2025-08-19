package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;
import com.beyondfootsteps.beyondfootsteps.services.RefugeeNaturalizationService;

@ExtendWith(MockitoExtension.class)
class RefugeeNaturalizationResolverTest {

    @Mock
    private RefugeeNaturalizationService refugeeNaturalizationService;
    @InjectMocks
    private RefugeeNaturalizationResolver refugeeNaturalizationResolver;

    @BeforeEach
    void setUp() {
        refugeeNaturalizationService = mock(RefugeeNaturalizationService.class);
        refugeeNaturalizationResolver = new RefugeeNaturalizationResolver(refugeeNaturalizationService);
    }

    @Test
    void shouldFindAllRefugeeNaturalizations() {
        RefugeeNaturalization decision = new RefugeeNaturalization();
        decision.setId("test-id");
        when(refugeeNaturalizationService.findAll()).thenReturn(List.of(decision));

        List<RefugeeNaturalization> result = refugeeNaturalizationResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldFindByYearAndCountry() {
        int year = 2025;
        String countryOfOriginIso = "AFG";
        String countryOfAsylumIso = "USA";
        RefugeeNaturalization decision = new RefugeeNaturalization();
        decision.setId("test-id");
        when(refugeeNaturalizationService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenReturn(List.of(decision));

        List<RefugeeNaturalization> result = refugeeNaturalizationResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldThrowInvalidParamExceptionWhenFindByYearAndCountryWithInvalidCountries() {
        int year = 2025;
        String countryOfOriginIso = null;
        String countryOfAsylumIso = null;
        when(refugeeNaturalizationService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenThrow(new InvalidParamException("At least one country must be provided"));

        InvalidParamException ex = assertThrows(InvalidParamException.class, () -> {
            refugeeNaturalizationResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        });
        assertNotNull(ex.getMessage());
    }

}
