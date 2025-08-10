package com.beyondfootsteps.beyondfootsteps.mappers;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;

public class ResettlementSummaryOriginGroupedMapper {

    private ResettlementSummaryOriginGroupedMapper() {
    }

    public static ResettlementSummaryOriginGroupedResponse toResponse(ResettlementSummaryOriginGroupedInternal internal) {
        return new ResettlementSummaryOriginGroupedResponse(
                internal.countriesIso(),
                internal.countriesNames(),
                internal.totalCases() != null ? internal.totalCases().intValue() : null,
                internal.totalDepartures() != null ? internal.totalDepartures().intValue() : null,
                internal.totalPersons() != null ? internal.totalPersons().intValue() : null,
                internal.totalNeeds() != null ? internal.totalNeeds().intValue() : null,
                internal.totalSubmissions() != null ? internal.totalSubmissions().intValue() : null,
                internal.coverageRate() != null ? internal.coverageRate().doubleValue() : null,
                internal.resettlementGap() != null ? internal.resettlementGap().doubleValue() : null,
                internal.requestVsNeedsRatio() != null ? internal.requestVsNeedsRatio().doubleValue() : null,
                internal.submissionsEfficiency() != null ? internal.submissionsEfficiency().floatValue() : null,
                internal.realizationRate() != null ? internal.realizationRate().doubleValue() : null
        );
    }

}
