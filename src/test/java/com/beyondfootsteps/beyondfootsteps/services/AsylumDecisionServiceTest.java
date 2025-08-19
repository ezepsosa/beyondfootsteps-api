package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumDecisionRepository;

@ExtendWith(MockitoExtension.class)
class AsylumDecisionServiceTest {

    @Mock
    private AsylumDecisionRepository asylumDecisionRepository;
    @InjectMocks
    private AsylumDecisionService asylumDecisionService;

    @Test
    void shouldFindAllAndReturnList() {
        AsylumDecision decision = new AsylumDecision();
        decision.setId("test-id");
        decision.setYear(2025);
        decision.setCountryOfOrigin("Afghanistan");
        decision.setCountryOfOriginIso("AFG");
        decision.setCountryOfAsylum("Spain");
        decision.setCountryOfAsylumIso("ESP");
        decision.setDecRecognized(100);
        decision.setDecOther(20);
        decision.setDecRejected(30);
        decision.setDecClosed(10);
        decision.setDecTotal(160);
        decision.setAcceptanceRate(0.75f);
        decision.setDecPc(true);

        when(asylumDecisionRepository.findAll()).thenReturn(List.of(decision));

        List<AsylumDecision> result = asylumDecisionService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals("Spain", result.get(0).getCountryOfAsylum());

    }

    @ParameterizedTest
    @CsvSource({
        "2025, ESP, AFG",
        "2025, ,AFG",
        "2025, ESP, "
    })
    void shouldFindByYearAndCountry(int year, String originCountry, String asylumCountry) {
        AsylumDecision decision = new AsylumDecision();
        decision.setId("test-id");
        decision.setYear(year);
        decision.setCountryOfOrigin("Afghanistan");
        decision.setCountryOfOriginIso(originCountry != null ? originCountry : "AFG");
        decision.setCountryOfAsylum("Spain");
        decision.setCountryOfAsylumIso(asylumCountry != null ? asylumCountry : "ESP");
        decision.setDecRecognized(100);
        decision.setDecOther(20);
        decision.setDecRejected(30);
        decision.setDecClosed(10);
        decision.setDecTotal(160);
        decision.setAcceptanceRate(0.75f);
        decision.setDecPc(true);

        when(asylumDecisionRepository.findByYearAndCountries(year, originCountry, asylumCountry))
                .thenReturn(List.of(decision));

        List<AsylumDecision> result = asylumDecisionService.findByYearAndCountry(year, originCountry, asylumCountry);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(year, result.get(0).getYear());
    }

    @Test
    void shouldNotFindByYearAndCountry() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> asylumDecisionService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
        assertEquals("At least one country must be provided", exception.getMessage());
    }
}
