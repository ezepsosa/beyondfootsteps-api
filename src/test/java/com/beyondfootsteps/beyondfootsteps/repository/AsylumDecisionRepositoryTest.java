package com.beyondfootsteps.beyondfootsteps.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumDecisionRepository;

@DataJpaTest
@ActiveProfiles("test")
class AsylumDecisionRepositoryTest {

    @Autowired
    private AsylumDecisionRepository asylumDecisionRepository;

    @ParameterizedTest
    @CsvSource({
        "2025, AFG, USA, 2025, AFG, USA, 1",
        "2025, AFG, USA, 2025, AFG, , 1",
        "2025, AFG, USA, 2025, , USA, 1",
        "2025, AFG, USA, 2026, AFG, USA, 0",
        "2025, AFG, USA, 2026, , , 0"
    })
    void shouldSaveAndFindByYearAndCountries(int year, String originCountry, String asylumCountry, int yearToLookFor, String countryOriginToLookFor, String countryAsylumToLookFor, int resultsExpected) {
        asylumDecisionRepository.deleteAll();
        AsylumDecision decision = new AsylumDecision();
        decision.setId("test-id");
        decision.setYear(year);
        decision.setCountryOfOriginIso(originCountry);
        decision.setCountryOfAsylumIso(asylumCountry);

        asylumDecisionRepository.save(decision);

        List<AsylumDecision> results = asylumDecisionRepository.findByYearAndCountries(yearToLookFor, countryOriginToLookFor, countryAsylumToLookFor);
        assertEquals(resultsExpected, results.size());
        if (resultsExpected > 0) {
            assertEquals("test-id", results.get(0).getId());
        }
    }

}
