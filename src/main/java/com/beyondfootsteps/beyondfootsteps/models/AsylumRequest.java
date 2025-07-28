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
@Table(name = "asylum_requests_kpi")
public class AsylumRequest {
    
    private int year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    private String countryOfAsylumIso;

    private String countryOfAsylum;

    private float appliedPer100k;

    private int applied;

}