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
@Table(name = "idp_displacement_kpi")
public class IdpDisplacement {

    @Id
    private String id;

    @Column(name = "\"year\"")
    private Integer year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private Integer total;

    @Column(name = "displacement_rate_per_100k")
    private Float displacementRatePer100k;

}