package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.repositories.IdpDisplacementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdpDisplacementService {

    private final IdpDisplacementRepository idpDisplacementRepository;

    public List<IdpDisplacement> findAll() {
        return idpDisplacementRepository.findAll();
    }
}
