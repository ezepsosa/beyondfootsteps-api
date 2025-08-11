package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.dto.internal.ResettlementSummaryOriginGroupedInternal;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedResponse;
import com.beyondfootsteps.beyondfootsteps.dto.response.ResettlementSummaryOriginGroupedYearResponse;
import com.beyondfootsteps.beyondfootsteps.mappers.ResettlementSummaryOriginGroupedMapper;
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

    public List<ResettlementSummaryOriginGroupedResponse> findByYearGroupedBy(int year, String grouping) {
        List<ResettlementSummaryOriginGroupedInternal> res = List.of();
        switch (grouping.toUpperCase()) {
            case "ORIGIN" ->
                res = resettlementSummaryRepository.findByYearGroupedByOriginCountry(year);
            case "ASYLUM" ->
                res = resettlementSummaryRepository.findByYearGroupedByAsylumCountry(year);
            case "RESETTLEMENT" ->
                res = resettlementSummaryRepository.findByYearGroupedByResettlementCountry(year);
            case "ORIGIN-ASYLUM" ->
                res = resettlementSummaryRepository.findByYearGroupedByOriginAsylumCountry(year);
            case "ASYLUM-RESETTLEMENT" ->
                res = resettlementSummaryRepository.findByYearGroupedByAsylumResettlementCountry(year);
            default -> {
            }
        }
        return res.stream().map(ResettlementSummaryOriginGroupedMapper::toResponse).toList();
    }

    public List<ResettlementSummaryOriginGroupedYearResponse> findGroupedByYear() {
        return resettlementSummaryRepository.findGroupedByYearAndAsylumCountry().stream().map(ResettlementSummaryOriginGroupedMapper::toResponseWithYear).toList();
    }
}
