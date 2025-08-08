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
    private String id;

    private Integer year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private String countryOfAsylum;

    private String countryOfAsylumIso;

    private Integer decRecognized;

    private Integer decOther;

    private Integer decRejected;

    private Integer decClosed;

    private Integer decTotal;

    private Float acceptanceRate;

    private Boolean decPc;
}