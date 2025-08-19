package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.services.DashboardSummaryService;

@SpringBootTest
class DashboardSummaryResolverTest {

    private DashboardSummaryService dashboardSummaryService;
    private DashboardSummaryResolver dashboardSummaryResolver;

    @BeforeEach
    void setUp() {
        dashboardSummaryService = mock(DashboardSummaryService.class);
        dashboardSummaryResolver = new DashboardSummaryResolver(dashboardSummaryService);
    }

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
