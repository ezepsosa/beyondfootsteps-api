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
@Table(name = "idp_displacement_kpi")
public class IdpDisplacement {

    @Id
    private int idIdpidmc;

    private int year;

    private String countryOfOrigin;

    private String countryOfOriginIso;

    private int total;

    private float displacementRatePer100k;

}

/*
 * id_idpidmc
year
country_of_origin
country_of_origin_iso
total
displacement_rate_per_100k
 */
