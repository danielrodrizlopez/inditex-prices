package com.inditex.prices.controller;

import com.inditex.prices.model.Price;
import com.inditex.prices.exception.PriceNotFoundException;
import com.inditex.prices.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class PriceController {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceController(PriceRepository priceRepository){
        this.priceRepository=priceRepository;
    }

    @GetMapping("/price")
    public ResponseEntity<?> getPrice(
        @RequestParam("productId") Long productId,
        @RequestParam("brandId") Long brandId,
        @RequestParam("date") LocalDateTime date){


        // buscamos el precio aplicable en funcion de los parametros
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, date, date);

        // return del precio encontrado o error
        if (prices.isEmpty()) {
            throw new PriceNotFoundException("No price found for the given parameters.");
        }
        else{
            // recuperamos el precio con la prioridad mas alta
            Price price = prices.stream().max(Comparator.comparing(Price::getPriority)).get();

            //creamos respuesta personalizada
            Map<String, Object> response = new HashMap<>();
            response.put("productId", price.getId());
            response.put("brandId", price.getBrandId());
            response.put("priceList", price.getPriceList());
            response.put("startDate", price.getStartDate());
            response.put("endDate", price.getEndDate());
            response.put("finalPrice", price.getPrice());

            return ResponseEntity.ok(response);
        }
    }
}
