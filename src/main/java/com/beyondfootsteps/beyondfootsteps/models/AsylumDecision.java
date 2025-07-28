package com.beyondfootsteps.beyondfootsteps.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asylum_decisions_kpi") 
public class AsylumDecision {

    private String idAsylumdecisions;

    private int year;

    private String countryOfOrigin;

    private String countryOfOriginISO;

    private String countryOfAsylum;

    private String countryOfAsylumISO;

    private int decRecognized;

    private int decOther;

    private int decRejected;

    private int decClosed;

    private int decTotal;

    private float acceptanceRate;

    private int intakeDate;
}