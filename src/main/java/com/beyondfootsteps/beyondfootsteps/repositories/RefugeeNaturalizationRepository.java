package com.beyondfootsteps.beyondfootsteps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;

@Repository
public interface RefugeeNaturalizationRepository extends JpaRepository<RefugeeNaturalization, String>{

}
