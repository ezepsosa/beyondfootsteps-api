package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;
import com.beyondfootsteps.beyondfootsteps.repositories.IdpReturneesRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing internal returnees
 */
@Service
@RequiredArgsConstructor
public class IdpReturneesService {

    private final IdpReturneesRepository idpReturneesRepository;

    private static final Logger logger = Logger.getLogger(IdpReturneesService.class.getName());

    /**
     * Retrieves all internal returnees from the repository
     *
     * @return a list of internal returnees
     */
    public List<IdpReturnees> findAll() {
        logger.info("Finding all internal returnees");
        return idpReturneesRepository.findAll();
    }

}
