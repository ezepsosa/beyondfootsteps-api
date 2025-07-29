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
@Table(name = "resettlements_summary_kpi")
public class ResettlementSummary {

    @Id
    private String id;

    private Integer year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    private String countryOfAsylumIso;

    private String countryOfAsylum;

    private String countryOfResettlementIso;

    private String countryOfResettlement;

    private Integer cases;

    private Integer persons;

    private Integer departuresTotal;

    private Integer totalNeeds;

    private Integer submissionsTotal;

    private Integer resettlementGap;

    private Float coverageRate;

    private Float requestVsNeedsRatio;

    private Float submissionsEfficiency;

    private Float realizationRate;
}