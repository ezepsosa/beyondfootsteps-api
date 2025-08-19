package com.beyondfootsteps.beyondfootsteps.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryGroupedByAsylumAndYearInternal;
import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.ResettlementSummaryRepository;

@DataJpaTest
@ActiveProfiles("test")
class ResettlementSummaryRepositoryTest {

    @Autowired
    private ResettlementSummaryRepository resettlementSummaryRepository;

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"})
    void shouldFindByYearGroupedByOriginCountry(int year, int resultExpected) {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfOriginIso("AFG");
        resettlementSummary.setCountryOfOrigin("Afghanistan");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryOriginGroupedInternal> results = resettlementSummaryRepository.findByYearGroupedByOriginCountry(year);
        assertEquals(resultExpected, results.size());
        if (resultExpected > 0) {
            assertEquals("AFG", results.get(0).countriesIso());
        }
    }

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"})
    void shouldFindByYearGroupedByAsylumCountry(int year, int resultExpected) {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfAsylumIso("AFG");
        resettlementSummary.setCountryOfAsylum("Afghanistan");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryOriginGroupedInternal> results = resettlementSummaryRepository.findByYearGroupedByAsylumCountry(year);
        assertEquals(resultExpected, results.size());
        if (resultExpected > 0) {
            assertEquals("AFG", results.get(0).countriesIso());
        }
    }

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"})
    void shouldFindByYearGroupedByResettlementCountry(int year, int resultExpected) {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfResettlementIso("AFG");
        resettlementSummary.setCountryOfResettlement("Afghanistan");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryOriginGroupedInternal> results = resettlementSummaryRepository.findByYearGroupedByResettlementCountry(year);
        assertEquals(resultExpected, results.size());
        if (resultExpected > 0) {
            assertEquals("AFG", results.get(0).countriesIso());
        }
    }

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"})
    void shouldFindByYearGroupedByOriginAsylumCountry(int year, int resultExpected) {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfAsylumIso("AFG");
        resettlementSummary.setCountryOfOriginIso("ESP");
        resettlementSummary.setCountryOfAsylum("Afghanistan");
        resettlementSummary.setCountryOfOrigin("Spain");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryOriginGroupedInternal> results = resettlementSummaryRepository.findByYearGroupedByOriginAsylumCountry(year);
        assertEquals(resultExpected, results.size());
        if (resultExpected > 0) {
            assertEquals("ESP-AFG", results.get(0).countriesIso());
        }
    }

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"})
    void shouldFindByYearGroupedByAsylumResettlementCountry(int year, int resultExpected) {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfAsylumIso("ECU");
        resettlementSummary.setCountryOfResettlementIso("ESP");
        resettlementSummary.setCountryOfAsylum("Ecuador");
        resettlementSummary.setCountryOfResettlement("Spain");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryOriginGroupedInternal> results = resettlementSummaryRepository.findByYearGroupedByAsylumResettlementCountry(year);
        assertEquals(resultExpected, results.size());
        if (resultExpected > 0) {
            assertEquals("ECU-ESP", results.get(0).countriesIso());
        }
    }

    @Test
    void shouldFindGroupedByYearAndAsylumCountry() {
        resettlementSummaryRepository.deleteAll();
        ResettlementSummary resettlementSummary = new ResettlementSummary();
        resettlementSummary.setId("test-id");
        resettlementSummary.setCountryOfAsylumIso("ESP");
        resettlementSummary.setCountryOfAsylum("Spain");
        resettlementSummary.setYear(2025);

        resettlementSummaryRepository.save(resettlementSummary);

        List<ResettlementSummaryGroupedByAsylumAndYearInternal> results = resettlementSummaryRepository.findGroupedByYearAndAsylumCountry();
        assertEquals(1, results.size());
        assertEquals("ESP", results.get(0).countriesIso());
    }

}
