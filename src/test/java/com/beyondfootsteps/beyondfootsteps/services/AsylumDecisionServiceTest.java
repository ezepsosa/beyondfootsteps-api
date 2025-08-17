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
import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumDecisionRepository;

@SpringBootTest
class AsylumDecisionServiceTest {

    private AsylumDecisionRepository asylumDecisionRepository;
    private AsylumDecisionService asylumDecisionService;

    @BeforeEach
    void setUp() {
        asylumDecisionRepository = mock(AsylumDecisionRepository.class);
        asylumDecisionService = new AsylumDecisionService(asylumDecisionRepository);
    }

    @Test
    void shouldFindAllAndReturnList() {
        when(asylumDecisionRepository.findAll()).thenReturn(Collections.emptyList());
        List<AsylumDecision> result = asylumDecisionService.findAll();
        assertNotNull(result);
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ESP, AFG",
        "2025, ,AFG",
        "2025, ESP, "
    })
    void shouldFindByYearAndOrigin(int year, String originCountry, String asylumCountry) {
        when(asylumDecisionRepository.findByYearAndCountries(year, originCountry, asylumCountry)).thenReturn(Collections.emptyList());
        List<AsylumDecision> result = asylumDecisionService.findByYearAndCountry(year, originCountry, asylumCountry);
        assertNotNull(result);
    }

    @Test
    void shouldNotFindByYearAndOrigin() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> asylumDecisionService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
    }
}
