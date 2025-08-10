package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.models.ResettlementSummary;
import com.beyondfootsteps.beyondfootsteps.repositories.ResettlementSummaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResettlementSummaryService {

    private final ResettlementSummaryRepository resettlementSummaryRepository;

    public List<ResettlementSummary> findAll() {
        return resettlementSummaryRepository.findAll();
    }

    public List<ResettlementSummaryOriginGroupedInternal> findByYearGroupedBy(int year, String grouping) {
        return resettlementSummaryRepository.findByYearGroupedByOriginCountry(year);
    }

}
