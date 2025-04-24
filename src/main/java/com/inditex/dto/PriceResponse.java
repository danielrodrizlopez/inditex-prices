package com.inditex.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PriceResponse {
    private Long brandId;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

    public PriceResponse(Long productId, Long brandId, Long priceList,
                         LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }


}