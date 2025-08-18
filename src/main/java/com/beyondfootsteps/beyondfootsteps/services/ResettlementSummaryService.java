package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.mappers.ResettlementSummaryOriginGroupedMapper;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.ResettlementSummaryRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing resettlement summary
 */
@Service
@RequiredArgsConstructor
public class ResettlementSummaryService {

    private final ResettlementSummaryRepository resettlementSummaryRepository;

    private static final Logger logger = Logger.getLogger(ResettlementSummaryService.class.getName());

    private static final Set<String> VALID_GROUPING = Set.of("ORIGIN", "ASYLUM", "RESETTLEMENT", "ORIGIN-ASYLUM", "ASYLUM-RESETTLEMENT");

    /**
     * Retrieves all resettlement summary from the repository.
     *
     * @return a list of resettlement summaries
     */
    public List<ResettlementSummary> findAll() {
        logger.info("Finding all ressettlement summaries");
        return resettlementSummaryRepository.findAll();
    }

    /**
     * Retrieves resettlement summaries filtered by year and grouped by origin
     * country, asylum country, resettlement country, origin and asylum
     * countries or asylum and resettlement countries
     *
     * @param year the year of the resettlement summary
     * @param grouping the mode to group the data. Values accepted: ORIGIN,
     * ASYLUM, RESETTLEMENT, ORIGIN-ASYLUM, ASYLUM-RESETTLEMENT
     * @return a list of resettlement summaries matching the criteria
     */
    public List<ResettlementSummaryOriginGroupedResponse> findByYearGroupedBy(int year, String grouping) {
        List<ResettlementSummaryOriginGroupedInternal> res = List.of();
        if (grouping == null || !VALID_GROUPING.contains(grouping)) {
            logger.warning("Grouping is null or is not one of the valid entries");
            throw new InvalidParamException("Grouping is null or is not one of the valid values [ORIGIN, ASYLUM, RESETTLEMENT, ORIGIN-ASYLUM, ASYLUM-RESETTLEMENT]");

        }
        logger.log(Level.INFO, "Finding resettlement summaries for year {0} and grouped by {1}", new Object[]{year, grouping.toLowerCase()});
        switch (grouping.toUpperCase()) {
            case "ORIGIN" ->
                res = resettlementSummaryRepository.findByYearGroupedByOriginCountry(year);
            case "ASYLUM" ->
                res = resettlementSummaryRepository.findByYearGroupedByAsylumCountry(year);
            case "RESETTLEMENT" ->
                res = resettlementSummaryRepository.findByYearGroupedByResettlementCountry(year);
            case "ORIGIN-ASYLUM" ->
                res = resettlementSummaryRepository.findByYearGroupedByOriginAsylumCountry(year);
            case "ASYLUM-RESETTLEMENT" ->
                res = resettlementSummaryRepository.findByYearGroupedByAsylumResettlementCountry(year);
            default -> {
            }
        }
        logger.log(Level.INFO, "Mapping resettlement summaries");
        return res.stream().map(ResettlementSummaryOriginGroupedMapper::toResponse).toList();
    }

    /**
     * Retrieves resettlement summaries grouped by year
     *
     * @return a list of resettlement summaries grouped by year
     */
    public List<ResettlementSummaryOriginGroupedYearResponse> findGroupedByYear() {
        logger.log(Level.INFO, "Finding resettlement summaries grouped by year");
        return resettlementSummaryRepository.findGroupedByYearAndAsylumCountry().stream().map(ResettlementSummaryOriginGroupedMapper::toResponseWithYear).toList();
    }
}
