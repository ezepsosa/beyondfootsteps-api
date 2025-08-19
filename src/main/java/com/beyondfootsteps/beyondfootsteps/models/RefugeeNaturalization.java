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
@Table(name = "refugee_naturalization_kpi")
public class RefugeeNaturalization {

    @Id
    private String id;

    @Column(name = "\"year\"")
    private Integer year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private String countryOfAsylum;

    private String countryOfAsylumIso;

    private Integer total;

    private Integer intakeDate;

    private Float naturalizationChange;
    

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
