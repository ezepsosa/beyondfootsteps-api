package com.beyondfootsteps.beyondfootsteps.dto.internal;

public record ResettlementSummaryGroupedByAsylumAndYearInternal(
        String countriesIso,
        String countriesNames,
        Number totalCases,
        Number totalDepartures,
        Number totalPersons,
        Number totalNeeds,
        Number totalSubmissions,
        Number year,
        Number coverageRate,
        Number resettlementGap,
        Number requestVsNeedsRatio,
        Number submissionsEfficiency,
        Number realizationRate
        ) {

}
