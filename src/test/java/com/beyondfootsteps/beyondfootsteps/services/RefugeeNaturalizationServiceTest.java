package com.beyondfootsteps.beyondfootsteps.services;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyondfootsteps.beyondfootsteps.exceptions.InvalidParamException;
import com.beyondfootsteps.beyondfootsteps.models.RefugeeNaturalization;
import com.beyondfootsteps.beyondfootsteps.repositories.RefugeeNaturalizationRepository;

@SpringBootTest
class RefugeeNaturalizationServiceTest {

    private RefugeeNaturalizationRepository refugeeNaturalizationRepository;
    private RefugeeNaturalizationService refugeeNaturalizationService;

    @BeforeEach
    void setUp() {
        refugeeNaturalizationRepository = mock(RefugeeNaturalizationRepository.class);
        refugeeNaturalizationService = new RefugeeNaturalizationService(refugeeNaturalizationRepository);
    }

    @Test
    void shouldFindAllAndReturnList() {
        when(refugeeNaturalizationRepository.findAll()).thenReturn(Collections.emptyList());
        List<RefugeeNaturalization> result = refugeeNaturalizationService.findAll();
        assertNotNull(result);
    }

    @ParameterizedTest
    @CsvSource({
        "2025, ESP, AFG",
        "2025, ,AFG",
        "2025, ESP, "
    })
    void shouldFindByYearAndCountry(int year, String originCountry, String asylumCountry) {
        when(refugeeNaturalizationRepository.findByYearAndCountries(year, originCountry, asylumCountry)).thenReturn(Collections.emptyList());
        List<RefugeeNaturalization> result = refugeeNaturalizationService.findByYearAndCountry(year, originCountry, asylumCountry);
        assertNotNull(result);
    }

    @Test
    void shouldNotFindByYearAndCountry() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> refugeeNaturalizationService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
    }
}
