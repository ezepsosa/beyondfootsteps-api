package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;
import com.beyondfootsteps.beyondfootsteps.repositories.RefugeeNaturalizationRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing refugee naturalizations
 */
@Service
@RequiredArgsConstructor
public class RefugeeNaturalizationService {

    private final RefugeeNaturalizationRepository refugeeNaturalizationRepository;

    private static final Logger logger = Logger.getLogger(RefugeeNaturalizationService.class.getName());

    /**
     * Retrieves all refugee naturalizations from the repository.
     *
     * @return a list of refugee naturalizations
     */
    public List<RefugeeNaturalization> findAll() {
        logger.info("Finding all refugee naturalizations");
        return refugeeNaturalizationRepository.findAll();
    }

    /**
     * Retrieves refugee naturalizations filtered by year and country of asylum
     * or origin
     *
     * @param year the year of the refugee naturalization
     * @param countryOfOriginIso the ISO code of the country of origin
     * @param countryOfAsylumIso the ISO code of the country of asylum
     * @return a list of refugee naturalizations matching the criteria
     */
    public List<RefugeeNaturalization> findByYearAndCountry(int year, String countryOfOriginIso, String countryOfAsylumIso) {
        if (countryOfOriginIso == null && countryOfAsylumIso == null) {
            logger.warning("Both countryOfOriginIso and countryOfAsylumIso are null");
            throw new InvalidParamException("At least one country must be provided");
        }
        logger.log(Level.INFO, "Finding refugee naturalizations for year: {0}, countryOfOrigin {1} and countryOfAsylum: {2}", new Object[]{year, countryOfOriginIso, countryOfAsylumIso});
        return refugeeNaturalizationRepository.findByYearAndCountries(year, countryOfOriginIso, countryOfAsylumIso);
    }
}
