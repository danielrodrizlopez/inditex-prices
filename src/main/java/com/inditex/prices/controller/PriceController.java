package com.inditex.prices.controller;

import com.inditex.prices.model.Price;
import com.inditex.prices.exception.PriceNotFoundException;
import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class PriceController {

    private final PriceService priceService;


    public PriceController(PriceService priceService){
        this.priceService=priceService;
    }

    @GetMapping("/price")
    public ResponseEntity<?> getPrice(
        @RequestParam("productId") Long productId,
        @RequestParam("brandId") Long brandId,
        @RequestParam("date") LocalDateTime date){

        return priceService.getFinalPrice(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PriceNotFoundException("No applicable price found"));

    }
}
