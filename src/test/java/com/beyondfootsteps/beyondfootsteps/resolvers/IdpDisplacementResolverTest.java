package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beyondfootsteps.beyondfootsteps.models.IdpDisplacement;
import com.beyondfootsteps.beyondfootsteps.services.IdpDisplacementService;

@ExtendWith(MockitoExtension.class)
class IdpDisplacementResolverTest {

    @Mock
    private IdpDisplacementService idpDisplacementService;
    @InjectMocks
    private IdpDisplacementResolver idpDisplacementResolver;

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
