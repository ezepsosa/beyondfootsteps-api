package com.beyondfootsteps.beyondfootsteps.dto.response;

public record ResettlementSummaryOriginGroupedResponse(
        String countriesIso,
        String countriesNames,
        Integer totalCases,
        Integer totalDepartures,
        Integer totalPersons,
        Integer totalNeeds,
        Integer totalSubmissions,
        Double coverageRate,
        Double resettlementGap,
        Double requestVsNeedsRatio,
        Float submissionsEfficiency,
        Double realizationRate) {

}
