package com.beyondfootsteps.beyondfootsteps.models;

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
    
    private int year;

    private String countryIso;

    private int totalApplied;

    private float appliedPer100k;

    private float acceptanceRate;

    private int internalDisplacementTotal;

    private float displacementRatePer100k;

    private int idpReturnees;

    private int refugeesReturnees;

    private int naturalizationsTotal;

    private float naturalizationChange;

    private int resettlementRequests;

    private int resettlementDepartures;

    private int resettlementSubmissions;

    private int resettlementNeeds;

    private float resettlementGaps;

    private float coverageRate;

    private float requestVsNeedsRatio;

    private float submissionsEfficiency;

    private float realizationRate;

}