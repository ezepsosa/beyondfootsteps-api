package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;
import com.beyondfootsteps.beyondfootsteps.repositories.AsylumRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsylumRequestService {

    private final AsylumRequestRepository asylumRequestRepository;

    public List<AsylumRequest> findAll() {
        return asylumRequestRepository.findAll();
    }

    public List<AsylumRequest> findByYearAndCountry(int year, String countryOfOriginIso, String countryOfAsylumIso) {
        return asylumRequestRepository.findByYearAndCountries(year, countryOfOriginIso, countryOfAsylumIso);
    }
}
