package com.beyondfootsteps.beyondfootsteps.resolvers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.models.IdpReturnees;
import com.beyondfootsteps.beyondfootsteps.services.IdpReturneesService;

@SpringBootTest
class IdpReturneesResolverTest {

    private IdpReturneesService idpReturneesService;
    private IdpReturneesResolver idpReturneesResolver;

    @BeforeEach
    void setUp() {
        idpReturneesService = mock(IdpReturneesService.class);
        idpReturneesResolver = new IdpReturneesResolver(idpReturneesService);
    }

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
