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

import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.services.ResettlementSummaryService;

@SpringBootTest
class ResettlementSummaryResolverTest {

    private ResettlementSummaryService resettlementSummaryService;
    private ResettlementSummaryResolver resettlementSummaryResolver;

    @BeforeEach
    void setUp() {
        resettlementSummaryService = mock(ResettlementSummaryService.class);
        resettlementSummaryResolver = new ResettlementSummaryResolver(resettlementSummaryService);
    }

    @Test
    void shouldFindAllResettlementSummaries() {
        ResettlementSummary summary = new ResettlementSummary();
        summary.setId("test-id");
        when(resettlementSummaryService.findAll()).thenReturn(List.of(summary));

        List<ResettlementSummary> result = resettlementSummaryResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldFindByYearGroupedBy() {
        int year = 2025;
        String grouping = "ORIGIN";
        ResettlementSummaryOriginGroupedResponse response = new ResettlementSummaryOriginGroupedResponse("AFG", "Afghanistan", 100, 80, 120, 150, 90, 0.75, 60.0, 0.60, 0.80f, 0.85);
        when(resettlementSummaryService.findByYearGroupedBy(year, grouping)).thenReturn(List.of(response));

        List<ResettlementSummaryOriginGroupedResponse> result = resettlementSummaryResolver.findByYearGroupedBy(year, grouping);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("AFG", result.get(0).countriesIso());
        assertEquals(100, result.get(0).totalCases());
    }

    @Test
    void shouldThrowInvalidParamExceptionWhenFindByYearGroupedByWithInvalidGrouping() {
        int year = 2025;
        String invalidGrouping = "INVALID";
        when(resettlementSummaryService.findByYearGroupedBy(year, invalidGrouping))
                .thenThrow(new InvalidParamException("Grouping is null or is not one of the valid values [ORIGIN, ASYLUM, RESETTLEMENT, ORIGIN-ASYLUM, ASYLUM-RESETTLEMENT]"));

        InvalidParamException ex = assertThrows(InvalidParamException.class, () -> {
            resettlementSummaryResolver.findByYearGroupedBy(year, invalidGrouping);
        });
        assertNotNull(ex.getMessage());
    }

    @Test
    void shouldFindGroupedByYear() {
        ResettlementSummaryOriginGroupedYearResponse response = new ResettlementSummaryOriginGroupedYearResponse("AFG", "Afghanistan", 100, 80, 120, 150, 90, 0.75, 60.0, 0.60, 0.80f, 0.85, 2025);
        when(resettlementSummaryService.findGroupedByYear()).thenReturn(List.of(response));

        List<ResettlementSummaryOriginGroupedYearResponse> result = resettlementSummaryResolver.findGroupedByYear();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("AFG", result.get(0).countriesIso());
        assertEquals(100, result.get(0).totalCases());
        assertEquals(2025, result.get(0).year());

    }

}
