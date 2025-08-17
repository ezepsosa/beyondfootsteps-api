package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumDecisionRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service for managing asylum decisions.
 */
@Service
@RequiredArgsConstructor
public class AsylumDecisionService {

    private static final Logger logger = Logger.getLogger(AsylumDecisionService.class.getName());

    private final AsylumDecisionRepository asylumDecisionRepository;

    /**
     * Retrieves all asylum decisions from the repository.
     *
     * @return a list of asylum decisions
     */
    public List<AsylumDecision> findAll() {
        logger.info("Finding all asylum decisions");
        return asylumDecisionRepository.findAll();
    }

    /**
     * Retrieves asylum decisions filtered by year and country of asylum or
     * origin.
     *
     * @param year the year of the asylum decision
     * @param countryOfOriginIso the ISO code of the country of origin
     * @param countryOfAsylumIso the ISO code of the country of asylum
     * @return a list of asylum decisions matching the criteria
     */
    public List<AsylumDecision> findByYearAndCountry(int year, String countryOfOriginIso, String countryOfAsylumIso) {
        if (countryOfOriginIso == null && countryOfAsylumIso == null) {
            logger.warning("Both countryOfOriginIso and countryOfAsylumIso are null");
            throw new InvalidParamException("At least one country must be provided");
        }
        logger.log(Level.INFO, "Finding asylum decisions for year: {0}, countryOfOrigin: {1}, countryOfAsylum: {2}", new Object[]{year, countryOfOriginIso, countryOfAsylumIso});
        return asylumDecisionRepository.findByYearAndCountries(year, countryOfOriginIso, countryOfAsylumIso);
    }
}
