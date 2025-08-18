package com.beyondfootsteps.beyondfootsteps.services;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.DashboardSummaryRepository;

@SpringBootTest
class DashboardSummaryServiceTest {

    private DashboardSummaryRepository dashboardSummaryRepository;
    private DashboardSummaryService dashboardSummaryService;

    @BeforeEach
    void setUp() {
        dashboardSummaryRepository = mock(DashboardSummaryRepository.class);
        dashboardSummaryService = new DashboardSummaryService(dashboardSummaryRepository);
    }

    @Test
    void shouldFindAllAndReturnList() {
        when(dashboardSummaryRepository.findAll()).thenReturn(Collections.emptyList());
        List<DashboardSummary> result = dashboardSummaryService.findAll();
        assertNotNull(result);
    }

    @Test
    void shouldFindByYear() {
        int year = 2025;
        when(dashboardSummaryRepository.findByYear(year)).thenReturn(Collections.emptyList());
        List<DashboardSummary> result = dashboardSummaryService.findByYear(year);
        assertNotNull(result);
    }
}
