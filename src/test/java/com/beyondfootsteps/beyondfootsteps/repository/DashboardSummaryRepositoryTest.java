package com.beyondfootsteps.beyondfootsteps.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.beyondfootsteps.beyondfootsteps.models.DashboardSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.DashboardSummaryRepository;

@DataJpaTest
@ActiveProfiles("test")
class DashboardSummaryRepositoryTest {

    @Autowired
    private DashboardSummaryRepository dashboardSummaryRepository;

    @ParameterizedTest
    @CsvSource({
        "2025, 1",
        "2026, 0"
    })
    void shouldSaveAndFindByYearAndCountries(int year, int expectedCount) {
        dashboardSummaryRepository.deleteAll();
        DashboardSummary summary = new DashboardSummary();
        summary.setId("test-id");
        summary.setYear(2025);

        dashboardSummaryRepository.save(summary);

        List<DashboardSummary> results = dashboardSummaryRepository.findByYear(year);
        assertEquals(expectedCount, results.size());
        if (expectedCount > 0) {
            assertEquals("test-id", results.get(0).getId());
        }
    }

}
