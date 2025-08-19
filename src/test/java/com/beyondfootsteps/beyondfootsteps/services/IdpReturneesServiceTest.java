package com.beyondfootsteps.beyondfootsteps.services;

import java.time.LocalDate;
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
import com.beyondfootsteps.beyondfootsteps.repositories.IdpReturneesRepository;


@ExtendWith(MockitoExtension.class)
class IdpReturneesServiceTest {

    @Mock
    private IdpReturneesRepository idpReturneesRepository;
    @InjectMocks
    private IdpReturneesService idpReturneesService;

    @Test
    void shouldFindAllAndReturnList() {
        IdpReturnees returnees = new IdpReturnees();
        returnees.setId("test-id");
        returnees.setYear(2025);
        returnees.setCountryOfOriginIso("AFG");
        returnees.setCountryOfOrigin("Afghanistan");
        returnees.setIdpReturneesNumber(1000);
        returnees.setRefugeesReturnees(500);
        returnees.setByDate(LocalDate.of(2025, 8, 18));

        when(idpReturneesRepository.findAll()).thenReturn(List.of(returnees));
        List<IdpReturnees> result = idpReturneesService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("AFG", result.get(0).getCountryOfOriginIso());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals(1000, result.get(0).getIdpReturneesNumber());
        assertEquals(500, result.get(0).getRefugeesReturnees());
        assertEquals(LocalDate.of(2025, 8, 18), result.get(0).getByDate());
    }

}
