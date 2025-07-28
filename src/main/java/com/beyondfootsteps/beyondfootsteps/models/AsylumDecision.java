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
@Table(name = "asylum_decisions_kpi")
public class AsylumDecision {
    
    @Id
    private String idAsylumdecisions;

    private int year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private String countryOfAsylum;

    private String countryOfAsylumIso;

    private int decRecognized;

    private int decOther;

    private int decRejected;

    private int decClosed;

    private int decTotal;

    private float acceptanceRate;

    private int intakeDate;
}