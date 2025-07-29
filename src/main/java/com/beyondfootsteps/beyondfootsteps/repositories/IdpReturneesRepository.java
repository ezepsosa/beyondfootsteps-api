package com.beyondfootsteps.beyondfootsteps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;

@Repository
public interface IdpReturneesRepository extends JpaRepository<IdpReturnees, String>{

}
