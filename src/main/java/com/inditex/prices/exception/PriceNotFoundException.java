package com.inditex.prices.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String s) {
        super(s);
    }
}
