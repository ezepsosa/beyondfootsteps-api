package com.beyondfootsteps.beyondfootsteps.models;

import java.time.LocalDate;

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
@Table(name = "idp_returnees_kpi")
public class IdpReturnees {

    @Id
    private String idIdpreturnees;

    private int year;

    private String countryOfOriginIso;

    private String countryOfOrigin;

    @Column(name = "idp_returnees")
    private int idpReturneesNumber;

    private int refugeesReturnees;

    private LocalDate byDate;

}