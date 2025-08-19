package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.services.IdpDisplacementService;

@SpringBootTest
class IdpDisplacementResolverTest {

    private IdpDisplacementService idpDisplacementService;
    private IdpDisplacementResolver idpDisplacementResolver;

    @BeforeEach
    void setUp() {
        idpDisplacementService = mock(IdpDisplacementService.class);
        idpDisplacementResolver = new IdpDisplacementResolver(idpDisplacementService);
    }

    @Test
    void shouldFindAllIdpDisplacements() {
        IdpDisplacement displacement = new IdpDisplacement();
        displacement.setId("test-id");
        when(idpDisplacementService.findAll()).thenReturn(List.of(displacement));

        List<IdpDisplacement> result = idpDisplacementResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

}
