package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumRequestRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing asylum requests
 */
@Service
@RequiredArgsConstructor
public class AsylumRequestService {

    private final AsylumRequestRepository asylumRequestRepository;

    private static final Logger logger = Logger.getLogger(AsylumRequestService.class.getName());

    /**
     * Retrieves all asylum requests from the repository.
     *
     * @return a list of asylum requests
     */
    public List<AsylumRequest> findAll() {
        return asylumRequestRepository.findAll();
    }

    /**
     * Retrieves asylum requests filtered by year and country of asylum or
     * origin
     *
     * @param year the year of the asylum request
     * @param countryOfOriginIso the ISO code of the country of origin
     * @param countryOfAsylumIso the ISO code of the country of asylum
     * @return a list of asylum decisions matching the criteria
     */
    public List<AsylumRequest> findByYearAndCountry(int year, String countryOfOriginIso, String countryOfAsylumIso) {
        if (countryOfOriginIso == null && countryOfAsylumIso == null) {
            logger.warning("Both countryOfOriginIso and countryOfAsylumIso are null");
            throw new InvalidParamException("At least one country must be provided");
        }
        logger.log(Level.INFO, "Finding asylum requests for year: {0}, countryOfOrigin {1} and countryOfAsylum: {2}", new Object[]{year, countryOfOriginIso, countryOfAsylumIso
        }
        );
        return asylumRequestRepository.findByYearAndCountries(year, countryOfOriginIso, countryOfAsylumIso);
    }
}
