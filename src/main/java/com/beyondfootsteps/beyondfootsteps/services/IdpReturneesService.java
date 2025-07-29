package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;
import com.beyondfootsteps.beyondfootsteps.repositories.IdpReturneesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdpReturneesService {

    private final IdpReturneesRepository idpReturneesRepository;

    public List<IdpReturnees> findAll(){
        return idpReturneesRepository.findAll();
    }

}
