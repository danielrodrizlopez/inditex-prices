package com.inditex.prices.service;

import com.inditex.prices.response.PriceResponse;
import com.inditex.prices.exception.PriceNotFoundException;
import com.inditex.prices.model.Price;
import com.inditex.prices.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceResponse> getFinalPrice(Long productId, Long brandId, LocalDateTime date) {

        // buscamos el precio aplicable en funcion de los parametros
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, date, date);

        // return del precio encontrado o error
        if (prices.isEmpty()) {
            throw new PriceNotFoundException("No price found for the given parameters.");
        }

        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .map(price -> new PriceResponse(
                        price.getProductId(),
                        price.getBrandId(),
                        price.getPriceList(),
                        price.getStartDate(),
                        price.getEndDate(),
                        price.getPrice()
                ));

    }
}
