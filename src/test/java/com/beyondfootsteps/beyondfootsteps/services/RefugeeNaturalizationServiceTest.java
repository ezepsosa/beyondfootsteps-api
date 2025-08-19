package com.beyondfootsteps.beyondfootsteps.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        RefugeeNaturalization naturalization = new RefugeeNaturalization();
        naturalization.setId("test-id");
        naturalization.setYear(2025);
        naturalization.setCountryOfOrigin("Afghanistan");
        naturalization.setCountryOfOriginIso("AFG");
        naturalization.setCountryOfAsylum("Spain");
        naturalization.setCountryOfAsylumIso("ESP");
        naturalization.setTotal(1000);
        naturalization.setIntakeDate(20250818);
        naturalization.setNaturalizationChange(1.5f);

        when(refugeeNaturalizationRepository.findAll()).thenReturn(List.of(naturalization));
        List<RefugeeNaturalization> result = refugeeNaturalizationService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(2025, result.get(0).getYear());
        assertEquals("Afghanistan", result.get(0).getCountryOfOrigin());
        assertEquals("AFG", result.get(0).getCountryOfOriginIso());
        assertEquals("Spain", result.get(0).getCountryOfAsylum());
        assertEquals("ESP", result.get(0).getCountryOfAsylumIso());
        assertEquals(1000, result.get(0).getTotal());
        assertEquals(20250818, result.get(0).getIntakeDate());
        assertEquals(1.5f, result.get(0).getNaturalizationChange());
    }

    @ParameterizedTest
    @CsvSource({
        "2025, Afghanistan, Spain, AFG, ESP",
        "2025, Afghanistan, , AFG, ",
        "2025, , Spain, , ESP"
    })
    void shouldFindByYearAndCountry(int year, String originCountry, String asylumCountry, String originCountryIso, String asylumCountryIso) {
        RefugeeNaturalization naturalization = new RefugeeNaturalization();
        naturalization.setId("test-id");
        naturalization.setYear(year);
        naturalization.setCountryOfOrigin(originCountry);
        naturalization.setCountryOfOriginIso(originCountryIso);
        naturalization.setCountryOfAsylum(asylumCountry);
        naturalization.setCountryOfAsylumIso(asylumCountryIso);
        naturalization.setTotal(500);
        naturalization.setIntakeDate(20250818);
        naturalization.setNaturalizationChange(2.0f);

        when(refugeeNaturalizationRepository.findByYearAndCountries(year, originCountry, asylumCountry)).thenReturn(List.of(naturalization));
        List<RefugeeNaturalization> result = refugeeNaturalizationService.findByYearAndCountry(year, originCountry, asylumCountry);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("test-id", result.get(0).getId());
        assertEquals(year, result.get(0).getYear());
        assertEquals(originCountry, result.get(0).getCountryOfOrigin());
        assertEquals(originCountryIso, result.get(0).getCountryOfOriginIso());
        assertEquals(asylumCountry, result.get(0).getCountryOfAsylum());
        assertEquals(asylumCountryIso, result.get(0).getCountryOfAsylumIso());
        assertEquals(500, result.get(0).getTotal());
        assertEquals(20250818, result.get(0).getIntakeDate());
        assertEquals(2.0f, result.get(0).getNaturalizationChange());
    }

    @Test
    void shouldNotFindByYearAndCountry() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                () -> refugeeNaturalizationService.findByYearAndCountry(2025, null, null));
        assertNotNull(exception.getMessage());
        assertEquals("At least one country must be provided", exception.getMessage());
    }
}
