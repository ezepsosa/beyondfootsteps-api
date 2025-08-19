package com.beyondfootsteps.beyondfootsteps.services;

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
import com.beyondfootsteps.beyondfootsteps.repositories.DashboardSummaryRepository;

@ExtendWith(MockitoExtension.class)
class DashboardSummaryServiceTest {
    @Mock
    private DashboardSummaryRepository dashboardSummaryRepository;
    @InjectMocks
    private DashboardSummaryService dashboardSummaryService;

    @Test
    void shouldFindAllAndReturnList() {
        DashboardSummary summary = new DashboardSummary();
        summary.setId("test-id");
        summary.setYear(2025);
        summary.setCountryIso("ESP");
        summary.setCountry("Spain");
        summary.setTotalApplied(1000);
        summary.setAppliedPer100k(12.5f);
        summary.setAcceptanceRate(0.85f);
        summary.setInternalDisplacementTotal(500);
        summary.setDisplacementRatePer100k(5.5f);
        summary.setIdpReturnees(200);
        summary.setRefugeesReturnees(150);
        summary.setNaturalizationsTotal(300);
        summary.setNaturalizationChange(1.2f);
        summary.setResettlementRequests(50);
        summary.setResettlementDepartures(40);
        summary.setResettlementSubmissions(45);
        summary.setResettlementNeeds(60);
        summary.setResettlementGap(10.0f);
        summary.setCoverageRate(0.67f);
        summary.setRequestVsNeedsRatio(0.83f);
        summary.setSubmissionsEfficiency(0.90f);
        summary.setRealizationRate(0.95f);

        when(dashboardSummaryRepository.findAll()).thenReturn(List.of(summary));
        List<DashboardSummary> result = dashboardSummaryService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("ESP", result.get(0).getCountryIso());
        assertEquals("Spain", result.get(0).getCountry());
        assertEquals(1000, result.get(0).getTotalApplied());
        assertEquals(12.5f, result.get(0).getAppliedPer100k());
        assertEquals(0.85f, result.get(0).getAcceptanceRate());
        assertEquals(500, result.get(0).getInternalDisplacementTotal());
        assertEquals(5.5f, result.get(0).getDisplacementRatePer100k());
        assertEquals(200, result.get(0).getIdpReturnees());
        assertEquals(150, result.get(0).getRefugeesReturnees());
        assertEquals(300, result.get(0).getNaturalizationsTotal());
        assertEquals(1.2f, result.get(0).getNaturalizationChange());
        assertEquals(50, result.get(0).getResettlementRequests());
        assertEquals(40, result.get(0).getResettlementDepartures());
        assertEquals(45, result.get(0).getResettlementSubmissions());
        assertEquals(60, result.get(0).getResettlementNeeds());
        assertEquals(10.0f, result.get(0).getResettlementGap());
        assertEquals(0.67f, result.get(0).getCoverageRate());
        assertEquals(0.83f, result.get(0).getRequestVsNeedsRatio());
        assertEquals(0.90f, result.get(0).getSubmissionsEfficiency());
        assertEquals(0.95f, result.get(0).getRealizationRate());
    }

    @Test
    void shouldFindByYear() {
        int year = 2025;
        DashboardSummary summary = new DashboardSummary();
        summary.setId("test-id");
        summary.setYear(year);
        summary.setCountryIso("ESP");
        summary.setCountry("Spain");
        summary.setTotalApplied(1000);
        summary.setAppliedPer100k(12.5f);
        summary.setAcceptanceRate(0.85f);
        summary.setInternalDisplacementTotal(500);
        summary.setDisplacementRatePer100k(5.5f);
        summary.setIdpReturnees(200);
        summary.setRefugeesReturnees(150);
        summary.setNaturalizationsTotal(300);
        summary.setNaturalizationChange(1.2f);
        summary.setResettlementRequests(50);
        summary.setResettlementDepartures(40);
        summary.setResettlementSubmissions(45);
        summary.setResettlementNeeds(60);
        summary.setResettlementGap(10.0f);
        summary.setCoverageRate(0.67f);
        summary.setRequestVsNeedsRatio(0.83f);
        summary.setSubmissionsEfficiency(0.90f);
        summary.setRealizationRate(0.95f);

        when(dashboardSummaryRepository.findByYear(year)).thenReturn(List.of(summary));
        List<DashboardSummary> result = dashboardSummaryService.findByYear(year);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(year, result.get(0).getYear());
        assertEquals("ESP", result.get(0).getCountryIso());
        assertEquals("Spain", result.get(0).getCountry());
        assertEquals(1000, result.get(0).getTotalApplied());
        assertEquals(12.5f, result.get(0).getAppliedPer100k());
        assertEquals(0.85f, result.get(0).getAcceptanceRate());
        assertEquals(500, result.get(0).getInternalDisplacementTotal());
        assertEquals(5.5f, result.get(0).getDisplacementRatePer100k());
        assertEquals(200, result.get(0).getIdpReturnees());
        assertEquals(150, result.get(0).getRefugeesReturnees());
        assertEquals(300, result.get(0).getNaturalizationsTotal());
        assertEquals(1.2f, result.get(0).getNaturalizationChange());
        assertEquals(50, result.get(0).getResettlementRequests());
        assertEquals(40, result.get(0).getResettlementDepartures());
        assertEquals(45, result.get(0).getResettlementSubmissions());
        assertEquals(60, result.get(0).getResettlementNeeds());
        assertEquals(10.0f, result.get(0).getResettlementGap());
        assertEquals(0.67f, result.get(0).getCoverageRate());
        assertEquals(0.83f, result.get(0).getRequestVsNeedsRatio());
        assertEquals(0.90f, result.get(0).getSubmissionsEfficiency());
        assertEquals(0.95f, result.get(0).getRealizationRate());
    }
}
