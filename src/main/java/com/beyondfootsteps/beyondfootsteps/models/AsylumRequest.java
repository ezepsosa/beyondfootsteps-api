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
@Table(name = "asylum_requests_kpi")
public class AsylumRequest {

    @Id
    private String id;

    private Integer year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    private String countryOfAsylumIso;

    private String countryOfAsylum;

    private Boolean appPc;

    @Column(name = "applied_per_100k")
    private Float appliedPer100k;

    private Integer applied;

}