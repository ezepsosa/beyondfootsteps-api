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

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;
import com.beyondfootsteps.beyondfootsteps.services.IdpReturneesService;

@ExtendWith(MockitoExtension.class)
class IdpReturneesResolverTest {

    @Mock
    private IdpReturneesService idpReturneesService;
    @InjectMocks
    private IdpReturneesResolver idpReturneesResolver;

    @Test
    void shouldFindAllIdpReturnees() {
        IdpReturnees returnee = new IdpReturnees();
        returnee.setId("test-id");
        when(idpReturneesService.findAll()).thenReturn(List.of(returnee));

        List<IdpReturnees> result = idpReturneesResolver.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
    }

}
