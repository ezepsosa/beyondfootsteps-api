package com.beyondfootsteps.beyondfootsteps.services;

import java.util.Collections;
import java.util.List;

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
        when(idpDisplacementRepository.findAll()).thenReturn(Collections.emptyList());
        List<IdpDisplacement> result = idpDisplacementService.findAll();
        assertNotNull(result);
    }

}
