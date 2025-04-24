package com.inditex.prices.service;

import com.inditex.prices.response.PriceResponse;
import com.inditex.prices.exception.PriceNotFoundException;
import com.inditex.prices.model.Price;
import com.inditex.prices.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFinalPrice_Success() {
        // creacion mock
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.parse("2025-04-24T10:00:00");

        Price mockPrice = new Price(1L, 1L, 100.0, LocalDateTime.parse("2025-04-23T00:00:00"), LocalDateTime.parse("2025-04-25T00:00:00"));
        List<Price> list = List.of(mockPrice);
        when(priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date,date)).thenReturn( list);


        PriceResponse result = priceService.getFinalPrice(productId, brandId, date).get();

        // assert
        assertNotNull(result);
        assertEquals(100.0, result.getPrice());
    }

    @Test
    public void testGetFinalPrice_NotFound() {
        // creacion mock
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.parse("2025-04-24T10:00:00");

        when(priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date, date)).thenReturn(Collections.emptyList());

        // Assert
        assertThrows(PriceNotFoundException.class, () -> priceService.getFinalPrice(productId, brandId, date));
    }
}
