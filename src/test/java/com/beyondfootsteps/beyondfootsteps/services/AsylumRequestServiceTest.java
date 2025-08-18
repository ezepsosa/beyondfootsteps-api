package com.beyondfootsteps.beyondfootsteps.services;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        when(asylumRequestRepository.findAll()).thenReturn(Collections.emptyList());
        List<AsylumRequest> result = asylumRequestService.findAll();
        assertNotNull(result);
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ESP, AFG",
        "2025, ,AFG",
        "2025, ESP, "
    })
    void shouldFindByYearAndCountry(int year, String originCountry, String asylumCountry) {
        when(asylumRequestRepository.findByYearAndCountries(year, originCountry, asylumCountry)).thenReturn(Collections.emptyList());
        List<AsylumRequest> result = asylumRequestService.findByYearAndCountry(year, originCountry, asylumCountry);
        assertNotNull(result);
    }

    @Test
    void shouldNotFindByYearAndCountry() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> asylumRequestService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
    }
}
