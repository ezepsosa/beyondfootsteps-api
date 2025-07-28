package com.beyondfootsteps.beyondfootsteps.models;

import jakarta.persistence.Entity;
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
@Table(name = "resettlement_sumamry_kpi")
public class ResettlementSummary {

    private int year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    private String countryOfAsylumIso;

    private String countryOfAsylum;

    private String countryOfResettlementIso;

    private String countryOfResettlemen;

    private int cases;

    private int persons;

    private int departuresTotal;

    private int totalNeeds;

    private int submissionsTotal;

    private int resettlementGap;

    private float coverageRate;

    private float requestVsNeedsRatio;

    private float submissionsEfficiency;

    private float realizationRate;
}