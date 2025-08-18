package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumRequestRepository;

@SpringBootTest
class AsylumRequestServiceTest {

    private AsylumRequestRepository asylumRequestRepository;
    private AsylumRequestService asylumRequestService;

    @BeforeEach
    void setUp() {
        asylumRequestRepository = mock(AsylumRequestRepository.class);
        asylumRequestService = new AsylumRequestService(asylumRequestRepository);
    }

    @Test
    void shouldFindAllAndReturnList() {
        AsylumRequest request = new AsylumRequest();
        request.setId("test-id");
        request.setYear(2025);
        request.setCountryOfOriginIso("AFG");
        request.setCountryOfOrigin("Afghanistan");
        request.setCountryOfAsylumIso("ESP");
        request.setCountryOfAsylum("Spain");
        request.setAppPc(true);
        request.setAppliedPer100k(12.5f);
        request.setApplied(100);

        when(asylumRequestRepository.findAll()).thenReturn(List.of(request));
        List<AsylumRequest> result = asylumRequestService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("AFG", result.get(0).getCountryOfOriginIso());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals("ESP", result.get(0).getCountryOfAsylumIso());
        assertEquals("Spain", result.get(0).getCountryOfAsylum());
        assertTrue(result.get(0).getAppPc());
        assertEquals(12.5f, result.get(0).getAppliedPer100k());
        assertEquals(100, result.get(0).getApplied());
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ESP, AFG",
        "2025, ,AFG",
        "2025, ESP, "
    })
    void shouldFindByYearAndCountry(int year, String originCountry, String asylumCountry) {
        AsylumRequest request = new AsylumRequest();
        request.setId("test-id");
        request.setYear(year);
        request.setCountryOfOriginIso(originCountry);
        request.setCountryOfOrigin("Origin");
        request.setCountryOfAsylumIso(asylumCountry);
        request.setCountryOfAsylum("Asylum");
        request.setAppPc(true);
        request.setAppliedPer100k(10.0f);
        request.setApplied(50);

        when(asylumRequestRepository.findByYearAndCountries(year, originCountry, asylumCountry)).thenReturn(List.of(request));
        List<AsylumRequest> result = asylumRequestService.findByYearAndCountry(year, originCountry, asylumCountry);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(year, result.get(0).getYear());
        assertEquals(originCountry, result.get(0).getCountryOfOriginIso());
        assertEquals("Origin", result.get(0).getCountryOfOrigin());
        assertEquals(asylumCountry, result.get(0).getCountryOfAsylumIso());
        assertEquals("Asylum", result.get(0).getCountryOfAsylum());
        assertTrue(result.get(0).getAppPc());
        assertEquals(10.0f, result.get(0).getAppliedPer100k());
        assertEquals(50, result.get(0).getApplied());
    }

    @Test
    void shouldNotFindByYearAndCountry() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> asylumRequestService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
        assertEquals("At least one country must be provided", exception.getMessage());
    }
}
