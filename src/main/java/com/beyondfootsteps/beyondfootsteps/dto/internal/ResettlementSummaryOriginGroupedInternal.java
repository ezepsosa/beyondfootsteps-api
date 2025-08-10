package com.beyondfootsteps.beyondfootsteps.dto.internal;

public record ResettlementSummaryOriginGroupedInternal(
        String countryOfOriginIso,
        Number totalCases,
        Number totalDepartures,
        Number totalPersons,
        Number totalNeeds,
        Number totalSubmissions,
        Number coverageRate,
        Number resettlementGap,
        Number requestVsNeedsRatio,
        Number submissionsEfficiency,
        Number realizationRate
        ) {

}
