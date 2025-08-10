package com.beyondfootsteps.beyondfootsteps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;

@Repository
public interface ResettlementSummaryRepository extends JpaRepository<ResettlementSummary, String> {

    @Query("SELECT new com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal("
    + "rssm.countryOfOriginIso, "
    + "SUM(rssm.cases), "
    + "SUM(rssm.departuresTotal), "
    + "SUM(rssm.persons), "
    + "SUM(rssm.totalNeeds), "
    + "SUM(rssm.submissionsTotal), "
    + "COALESCE(CASE WHEN SUM(rssm.totalNeeds) > 0 THEN ROUND(SUM(rssm.departuresTotal) / SUM(rssm.totalNeeds), 3) ELSE NULL END, NULL), "
    + "COALESCE(SUM(rssm.totalNeeds) - SUM(rssm.departuresTotal), NULL), "
    + "COALESCE(CASE WHEN SUM(rssm.totalNeeds) > 0 THEN ROUND(SUM(rssm.persons) / SUM(rssm.totalNeeds), 3) END, NULL), "
    + "COALESCE(CASE WHEN SUM(rssm.submissionsTotal) > 0 THEN ROUND(SUM(rssm.persons) / SUM(rssm.submissionsTotal), 3) END, NULL), "
    + "COALESCE(CASE WHEN SUM(rssm.submissionsTotal) > 0 THEN ROUND(SUM(rssm.departuresTotal) / SUM(rssm.submissionsTotal), 3) END, NULL)) "
    + "FROM ResettlementSummary rssm WHERE rssm.year = :year GROUP BY rssm.countryOfOriginIso, rssm.countryOfOrigin")
    List<ResettlementSummaryOriginGroupedInternal> findByYearGroupedByOriginCountry(int year);

}
