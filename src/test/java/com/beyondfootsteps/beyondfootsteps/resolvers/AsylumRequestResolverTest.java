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
import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;
import com.beyondfootsteps.beyondfootsteps.services.AsylumRequestService;

@SpringBootTest
class AsylumRequestResolverTest {

    private AsylumRequestService asylumRequestService;
    private AsylumRequestResolver asylumRequestResolver;

    @BeforeEach
    void setUp() {
        asylumRequestService = mock(AsylumRequestService.class);
        asylumRequestResolver = new AsylumRequestResolver(asylumRequestService);
    }

    @Test
    void shouldFindAllAsylumRequests() {
        AsylumRequest request = new AsylumRequest();
        request.setId("test-id");
        when(asylumRequestService.findAll()).thenReturn(List.of(request));

        List<AsylumRequest> result = asylumRequestResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldFindByYearAndCountry() {
        int year = 2025;
        String countryOfOriginIso = "AFG";
        String countryOfAsylumIso = "USA";
        AsylumRequest request = new AsylumRequest();
        request.setId("test-id");
        when(asylumRequestService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenReturn(List.of(request));

        List<AsylumRequest> result = asylumRequestResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldThrowInvalidParamExceptionWhenFindByYearAndCountryWithInvalidCountries() {
        int year = 2025;
        String countryOfOriginIso = null;
        String countryOfAsylumIso = null;
        when(asylumRequestService.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso))
                .thenThrow(new InvalidParamException("At least one country must be provided"));

        InvalidParamException ex = assertThrows(InvalidParamException.class, () -> {
            asylumRequestResolver.findByYearAndCountry(year, countryOfOriginIso, countryOfAsylumIso);
        });
        assertNotNull(ex.getMessage());
    }

}
