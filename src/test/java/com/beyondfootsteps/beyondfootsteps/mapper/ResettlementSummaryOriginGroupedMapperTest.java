package com.beyondfootsteps.beyondfootsteps.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryGroupedByAsylumAndYearInternal;
import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.mappers.ResettlementSummaryOriginGroupedMapper;

class ResettlementSummaryOriginGroupedMapperTest {

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponse() {
        ResettlementSummaryOriginGroupedInternal internal = new ResettlementSummaryOriginGroupedInternal("countries", "countries-names", 25, 20, 22, 43, 10, 0.24, 0.1, 0.4, 0.53f, 0.55);

        ResettlementSummaryOriginGroupedResponse response = ResettlementSummaryOriginGroupedMapper.toResponse(internal);

        assertEquals("countries", response.countriesIso());
        assertEquals("countries-names", response.countriesNames());
        assertEquals(25, response.totalCases());
        assertEquals(20, response.totalDepartures());
        assertEquals(22, response.totalPersons());
        assertEquals(43, response.totalNeeds());
        assertEquals(10, response.totalSubmissions());
        assertEquals(0.24, response.coverageRate());
        assertEquals(0.1, response.resettlementGap());
        assertEquals(0.4, response.requestVsNeedsRatio());
        assertEquals(0.53f, response.submissionsEfficiency());
        assertEquals(0.55, response.realizationRate());

    }

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponseWithNullValues() {
        ResettlementSummaryOriginGroupedInternal internal = new ResettlementSummaryOriginGroupedInternal(null, null, null, null, null, null, null, null, null, null, null, null);

        ResettlementSummaryOriginGroupedResponse response = ResettlementSummaryOriginGroupedMapper.toResponse(internal);

        assertEquals(null, response.countriesIso());
        assertEquals(null, response.countriesNames());
        assertEquals(null, response.totalCases());
        assertEquals(null, response.totalDepartures());
        assertEquals(null, response.totalPersons());
        assertEquals(null, response.totalNeeds());
        assertEquals(null, response.totalSubmissions());
        assertEquals(null, response.coverageRate());
        assertEquals(null, response.resettlementGap());
        assertEquals(null, response.requestVsNeedsRatio());
        assertEquals(null, response.submissionsEfficiency());
        assertEquals(null, response.realizationRate());

    }

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponseHandlingExtremeValues() {
        ResettlementSummaryOriginGroupedInternal internal = new ResettlementSummaryOriginGroupedInternal(null, null, -1, -1, -1, -1, -1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Float.NaN, Double.NaN);

        ResettlementSummaryOriginGroupedResponse response = ResettlementSummaryOriginGroupedMapper.toResponse(internal);

        assertEquals(null, response.countriesIso());
        assertEquals(null, response.countriesNames());
        assertEquals(-1, response.totalCases());
        assertEquals(-1, response.totalDepartures());
        assertEquals(-1, response.totalPersons());
        assertEquals(-1, response.totalNeeds());
        assertEquals(-1, response.totalSubmissions());
        assertEquals(Double.NaN, response.coverageRate());
        assertEquals(Double.POSITIVE_INFINITY, response.resettlementGap());
        assertEquals(Double.NEGATIVE_INFINITY, response.requestVsNeedsRatio());
        assertEquals(Float.NaN, response.submissionsEfficiency());
        assertEquals(Double.NaN, response.realizationRate());
    }

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponseWithYear() {
        ResettlementSummaryGroupedByAsylumAndYearInternal internal = new ResettlementSummaryGroupedByAsylumAndYearInternal("countries", "countries-names", 25, 20, 22, 43, 10, 2025, 0.24, 0.1, 0.4, 0.53f, 0.55);

        ResettlementSummaryOriginGroupedYearResponse response = ResettlementSummaryOriginGroupedMapper.toResponseWithYear(internal);

        assertEquals("countries", response.countriesIso());
        assertEquals("countries-names", response.countriesNames());
        assertEquals(25, response.totalCases());
        assertEquals(20, response.totalDepartures());
        assertEquals(22, response.totalPersons());
        assertEquals(43, response.totalNeeds());
        assertEquals(2025, response.year());
        assertEquals(10, response.totalSubmissions());
        assertEquals(0.24, response.coverageRate());
        assertEquals(0.1, response.resettlementGap());
        assertEquals(0.4, response.requestVsNeedsRatio());
        assertEquals(0.53f, response.submissionsEfficiency());
        assertEquals(0.55, response.realizationRate());

    }

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponseWithYearWithNullValues() {
        ResettlementSummaryGroupedByAsylumAndYearInternal internal = new ResettlementSummaryGroupedByAsylumAndYearInternal(null, null, null, null, null, null, null, null, null, null, null, null, null);

        ResettlementSummaryOriginGroupedYearResponse response = ResettlementSummaryOriginGroupedMapper.toResponseWithYear(internal);

        assertEquals(null, response.countriesIso());
        assertEquals(null, response.countriesNames());
        assertEquals(null, response.totalCases());
        assertEquals(null, response.totalDepartures());
        assertEquals(null, response.totalPersons());
        assertEquals(null, response.totalNeeds());
        assertEquals(null, response.year());
        assertEquals(null, response.totalSubmissions());
        assertEquals(null, response.coverageRate());
        assertEquals(null, response.resettlementGap());
        assertEquals(null, response.requestVsNeedsRatio());
        assertEquals(null, response.submissionsEfficiency());
        assertEquals(null, response.realizationRate());

    }

    @Test
    void shouldMapperResettlementSummaryOriginGroupedInternalToResponseWithYearHandleingExtremeValue() {
        ResettlementSummaryGroupedByAsylumAndYearInternal internal = new ResettlementSummaryGroupedByAsylumAndYearInternal(null, null, -1, -1, -1, -1, -1, Integer.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Float.NaN, Double.NaN);

        ResettlementSummaryOriginGroupedYearResponse response = ResettlementSummaryOriginGroupedMapper.toResponseWithYear(internal);

        assertEquals(null, response.countriesIso());
        assertEquals(null, response.countriesNames());
        assertEquals(-1, response.totalCases());
        assertEquals(-1, response.totalDepartures());
        assertEquals(-1, response.totalPersons());
        assertEquals(-1, response.totalNeeds());
        assertEquals(-1, response.totalSubmissions());
        assertEquals(Integer.MAX_VALUE, response.year());
        assertEquals(Double.NaN, response.coverageRate());
        assertEquals(Double.POSITIVE_INFINITY, response.resettlementGap());
        assertEquals(Double.NEGATIVE_INFINITY, response.requestVsNeedsRatio());
        assertEquals(Float.NaN, response.submissionsEfficiency());
        assertEquals(Double.NaN, response.realizationRate());

    }

}
