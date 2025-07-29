package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.AsylumDecision;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumDecisionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsylumDecisionService {

    private final AsylumDecisionRepository asylumDecisionRepository;

    public List<AsylumDecision> findAll() {
        return asylumDecisionRepository.findAll();
    }
}
