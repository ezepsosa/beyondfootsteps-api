package com.beyondfootsteps.beyondfootsteps.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dashboard_summary_kpi")
public class DashboardSummary {

    @Id
    private String id;

    private Integer year;

    private String countryIso;

    private String country;

    private Integer totalApplied;

    @Column(name = "applied_per_100k")
    private Float appliedPer100k;

    private Float acceptanceRate;

    private Integer internalDisplacementTotal;

    @Column(name = "displacement_rate_per_100k")
    private Float displacementRatePer100k;

    private Integer idpReturnees;

    private Integer refugeesReturnees;

    private Integer naturalizationsTotal;

    private Float naturalizationChange;

    private Integer resettlementRequests;

    private Integer resettlementDepartures;

    private Integer resettlementSubmissions;

    private Integer resettlementNeeds;

    private Float resettlementGap;

    private Float coverageRate;

    private Float requestVsNeedsRatio;

    private Float submissionsEfficiency;

    private Float realizationRate;

}