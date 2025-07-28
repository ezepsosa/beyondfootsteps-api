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
@Table(name = "asylum_requests_kpi")
public class AsylumRequest {
    
    @Id
    private String id;

    private int year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    private String countryOfAsylumIso;

    private String countryOfAsylum;

    private float appliedPer100k;

    private int applied;

}