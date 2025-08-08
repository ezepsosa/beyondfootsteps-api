package com.beyondfootsteps.beyondfootsteps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;

@Repository
public interface RefugeeNaturalizationRepository extends JpaRepository<RefugeeNaturalization, String> {

    @Query("SELECT a FROM RefugeeNaturalization a WHERE a.year = :year "
            + "AND (:countryOfOriginIso IS NULL OR a.countryOfOriginIso = :countryOfOriginIso) "
            + "AND (:countryOfAsylumIso IS NULL OR a.countryOfAsylumIso = :countryOfAsylumIso)")
    List<RefugeeNaturalization> findByYearAndCountries(@Param("year") int year,
            @Param("countryOfOriginIso") String countryOfOriginIso,
            @Param("countryOfAsylumIso") String countryOfAsylumIso);
}
