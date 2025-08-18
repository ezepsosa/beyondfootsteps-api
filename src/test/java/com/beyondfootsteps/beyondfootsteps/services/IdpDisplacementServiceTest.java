package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.repositories.IdpDisplacementRepository;

@SpringBootTest
class IdpDisplacementServiceTest {

    private IdpDisplacementRepository idpDisplacementRepository;
    private IdpDisplacementService idpDisplacementService;

    @BeforeEach
    void setUp() {
        idpDisplacementRepository = mock(IdpDisplacementRepository.class);
        idpDisplacementService = new IdpDisplacementService(idpDisplacementRepository);
    }

    @Test
    void shouldFindAllAndReturnList() {
        IdpDisplacement displacement = new IdpDisplacement();
        displacement.setId("test-id");
        displacement.setYear(2025);
        displacement.setCountryOfOrigin("Afghanistan");
        displacement.setCountryOfOriginIso("AFG");
        displacement.setTotal(1000);
        displacement.setDisplacementRatePer100k(12.5f);

        when(idpDisplacementRepository.findAll()).thenReturn(List.of(displacement));
        List<IdpDisplacement> result = idpDisplacementService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals("AFG", result.get(0).getCountryOfOriginIso());
        assertEquals(1000, result.get(0).getTotal());
        assertEquals(12.5f, result.get(0).getDisplacementRatePer100k());
    }

}
