package com.beyondfootsteps.beyondfootsteps.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name="asylum_requests_kpi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AsylumRequest {
    private int year;

    private String countryOfOriginISO;

    private String countryOfOrigin;

    private String countryOfAsylumISO;
    
    private String countryOfAsylum;

    private float appliedPer100k;

    private int applied;



}

/*
 * year
population
country_of_origin_iso
country_of_origin
country_of_asylum_iso
country_of_asylum
applied_per_100k
applied
 */