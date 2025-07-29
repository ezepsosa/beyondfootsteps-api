package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;
import com.beyondfootsteps.beyondfootsteps.repositories.RefugeeNaturalizationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefugeeNaturalizationService {

    private final RefugeeNaturalizationRepository refugeeNaturalizationRepository;

    public List<RefugeeNaturalization> findAll() {
        return refugeeNaturalizationRepository.findAll();
    }
}
