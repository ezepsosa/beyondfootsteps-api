package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryGroupedByAsylumAndYearInternal;
import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.ResettlementSummaryRepository;

@ExtendWith(MockitoExtension.class)
class ResettlementSummaryServiceTest {

    @Mock
    private ResettlementSummaryRepository resettlementSummaryRepository;
    @InjectMocks
    private ResettlementSummaryService resettlementSummaryService;

    @BeforeEach
    void setUp() {
        int year = 2025;
        ResettlementSummary summary = new ResettlementSummary("test-id", 2025, "AFG", "Afghanistan", "ESP", "Spain", "USA", "United States", 100, 120, 80, 150, 90, 60, 0.75f, 0.60f, 0.80f, 0.85f);
        ResettlementSummaryOriginGroupedInternal internal = new ResettlementSummaryOriginGroupedInternal("AFG", "Afghanistan", 100, 80, 120, 150, 90, 0.75, 60.0, 0.60, 0.80f, 0.85);
        lenient().when(resettlementSummaryRepository.findAll()).thenReturn(List.of(summary));
        lenient().when(resettlementSummaryRepository.findByYearGroupedByOriginCountry(year)).thenReturn(List.of(internal));
        lenient().when(resettlementSummaryRepository.findByYearGroupedByAsylumCountry(year)).thenReturn(List.of(internal));
        lenient().when(resettlementSummaryRepository.findByYearGroupedByResettlementCountry(year)).thenReturn(List.of(internal));
        lenient().when(resettlementSummaryRepository.findByYearGroupedByOriginAsylumCountry(year)).thenReturn(List.of(internal));
        lenient().when(resettlementSummaryRepository.findByYearGroupedByAsylumResettlementCountry(year)).thenReturn(List.of(internal));
        ResettlementSummaryGroupedByAsylumAndYearInternal internalYear = new ResettlementSummaryGroupedByAsylumAndYearInternal("AFG", "Afghanistan", 100, 80, 120, 150, 90, 2025, 0.75, 60.0, 0.60, 0.80f, 0.85);
        lenient().when(resettlementSummaryRepository.findGroupedByYearAndAsylumCountry()).thenReturn(List.of(internalYear));

    }

    @Test
    void shouldFindAllAndReturnList() {
        List<ResettlementSummary> result = resettlementSummaryService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("AFG", result.get(0).getCountryOfOriginIso());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals("ESP", result.get(0).getCountryOfAsylumIso());
        assertEquals("Spain", result.get(0).getCountryOfAsylum());
        assertEquals("USA", result.get(0).getCountryOfResettlementIso());
        assertEquals("United States", result.get(0).getCountryOfResettlement());
        assertEquals(100, result.get(0).getCases());
        assertEquals(120, result.get(0).getPersons());
        assertEquals(80, result.get(0).getDeparturesTotal());
        assertEquals(150, result.get(0).getTotalNeeds());
        assertEquals(90, result.get(0).getSubmissionsTotal());
        assertEquals(60, result.get(0).getResettlementGap());
        assertEquals(0.75f, result.get(0).getCoverageRate());
        assertEquals(0.60f, result.get(0).getRequestVsNeedsRatio());
        assertEquals(0.80f, result.get(0).getSubmissionsEfficiency());
        assertEquals(0.85f, result.get(0).getRealizationRate());
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ORIGIN",
        "2025, ASYLUM",
        "2025, RESETTLEMENT",
        "2025, ORIGIN-ASYLUM",
        "2025, ASYLUM-RESETTLEMENT",})
    void shouldFindByYearGroupedBy(int year, String grouping) {
        List<ResettlementSummaryOriginGroupedResponse> result = resettlementSummaryService.findByYearGroupedBy(year, grouping);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(100, result.get(0).totalCases());
        assertEquals(80, result.get(0).totalDepartures());
        assertEquals(120, result.get(0).totalPersons());
        assertEquals(150, result.get(0).totalNeeds());
        assertEquals(90, result.get(0).totalSubmissions());
        assertEquals(0.75, result.get(0).coverageRate());
        assertEquals(60.0, result.get(0).resettlementGap());
        assertEquals(0.60, result.get(0).requestVsNeedsRatio());
        assertEquals(0.80f, result.get(0).submissionsEfficiency());
        assertEquals(0.85, result.get(0).realizationRate());
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ",
        "2025, not-valid"})
    void shouldNotFindByYearGroupedBy(Integer year, String grouping) {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> resettlementSummaryService.findByYearGroupedBy(year, grouping));
        assertNotNull(exception.getMessage());
        assertEquals("Grouping is null or is not one of the valid values [ORIGIN, ASYLUM, RESETTLEMENT, ORIGIN-ASYLUM, ASYLUM-RESETTLEMENT]", exception.getMessage());
    }

    @Test
    void shouldFindGroupedByYear() {
        List<ResettlementSummaryOriginGroupedYearResponse> result = resettlementSummaryService.findGroupedByYear();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(100, result.get(0).totalCases());
        assertEquals(80, result.get(0).totalDepartures());
        assertEquals(120, result.get(0).totalPersons());
        assertEquals(150, result.get(0).totalNeeds());
        assertEquals(90, result.get(0).totalSubmissions());
        assertEquals(0.75, result.get(0).coverageRate());
        assertEquals(60.0, result.get(0).resettlementGap());
        assertEquals(0.60, result.get(0).requestVsNeedsRatio());
        assertEquals(0.80f, result.get(0).submissionsEfficiency());
        assertEquals(0.85, result.get(0).realizationRate());
        assertEquals(2025, result.get(0).year());
    }
}
