package com.beyondfootsteps.beyondfootsteps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.AsylumRequest;

@Repository
public interface AsylumRequestRepository extends JpaRepository<AsylumRequest, String>{

}
