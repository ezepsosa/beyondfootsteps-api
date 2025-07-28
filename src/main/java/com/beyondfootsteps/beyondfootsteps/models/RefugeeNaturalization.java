package com.beyondfootsteps.beyondfootsteps.models;

import jakarta.persistence.Id;
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
@Table(name = "refugee_naturalization_kpi")
public class RefugeeNaturalization {

    @Id
    private String idRefugeenaturalization;

    private int year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private String countryOfAsylum;

    private String countryOfAsylumIso;

    private int total;

    private int intakeDate;

    private float naturalizationChange;
    

}

/*id_refugeenaturalization
year
country_of_origin
country_of_origin_iso
country_of_asylum
country_of_asylum_iso
total
intake_date
naturalization_change */
