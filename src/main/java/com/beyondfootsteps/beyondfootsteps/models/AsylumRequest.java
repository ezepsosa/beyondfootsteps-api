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