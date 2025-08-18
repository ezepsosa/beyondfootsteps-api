package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.repositories.IdpDisplacementRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * Service for managing internal displacement
 */
@Service
@RequiredArgsConstructor
public class IdpDisplacementService {

    private final IdpDisplacementRepository idpDisplacementRepository;

    private static final Logger logger = Logger.getLogger(IdpDisplacementService.class.getName());

    /**
     * Retrieves all internal displacement from the repository
     *
     * @return a list of internal displacement
     */
    public List<IdpDisplacement> findAll() {
        logger.info("Finding all internal displacement");
        return idpDisplacementRepository.findAll();
    }
}
