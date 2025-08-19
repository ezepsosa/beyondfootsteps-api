package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.services.DashboardSummaryService;

@ExtendWith(MockitoExtension.class)
class DashboardSummaryResolverTest {

    @Mock
    private DashboardSummaryService dashboardSummaryService;
    @InjectMocks
    private DashboardSummaryResolver dashboardSummaryResolver;

    @Test
    void shouldFindAllDashboardSummaries() {
        DashboardSummary summary = new DashboardSummary();
        summary.setId("test-id");
        when(dashboardSummaryService.findAll()).thenReturn(List.of(summary));

        List<DashboardSummary> result = dashboardSummaryResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

    @Test
    void shouldFindByYear() {
        int year = 2025;
        DashboardSummary summary = new DashboardSummary();
        summary.setId("test-id");
        when(dashboardSummaryService.findByYear(year))
                .thenReturn(List.of(summary));

        List<DashboardSummary> result = dashboardSummaryResolver.findByYear(year);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

}
