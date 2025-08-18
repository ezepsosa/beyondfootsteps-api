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

import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.ResettlementSummaryRepository;

@SpringBootTest
class ResettlementSummaryServiceTest {

    private ResettlementSummaryRepository resettlementSummaryRepository;
    private ResettlementSummaryService resettlementSummaryService;

    @BeforeEach
    void setUp() {
        resettlementSummaryRepository = mock(ResettlementSummaryRepository.class);
        resettlementSummaryService = new ResettlementSummaryService(resettlementSummaryRepository);
        int year = 2025;
        when(resettlementSummaryRepository.findByYearGroupedByOriginCountry(year)).thenReturn(Collections.emptyList());
        when(resettlementSummaryRepository.findByYearGroupedByAsylumCountry(year)).thenReturn(Collections.emptyList());
        when(resettlementSummaryRepository.findByYearGroupedByResettlementCountry(year)).thenReturn(Collections.emptyList());
        when(resettlementSummaryRepository.findByYearGroupedByOriginAsylumCountry(year)).thenReturn(Collections.emptyList());
        when(resettlementSummaryRepository.findByYearGroupedByAsylumResettlementCountry(year)).thenReturn(Collections.emptyList());

    }
    

    @Test
    void shouldFindAllAndReturnList() {
        when(resettlementSummaryRepository.findAll()).thenReturn(Collections.emptyList());
        List<ResettlementSummary> result = resettlementSummaryService.findAll();
        assertNotNull(result);
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
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ",
        "2025, not-valid",})
    void shouldNotFindByYearGroupedBy() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> resettlementSummaryService.findByYearGroupedBy(2025, null));
        assertNotNull(exception.getMessage());
    }

    @Test
    void shouldFindGroupedByYear() {
        when(resettlementSummaryRepository.findGroupedByYearAndAsylumCountry()).thenReturn(Collections.emptyList());
        List<ResettlementSummaryOriginGroupedYearResponse> result = resettlementSummaryService.findGroupedByYear();
        assertNotNull(result);
    }
}
