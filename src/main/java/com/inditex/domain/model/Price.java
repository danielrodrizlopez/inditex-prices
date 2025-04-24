package com.inditex.domain.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

/**
 * Clase que representa la entidad de precios de un producto para una marca
 */
@Entity
@Table(name = "PRICES")
public class Price {

    /**
     * Identificador unico para cada precio en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Identificador de la marca a la que pertenece el producto
     */
    @Column(name = "BRAND_ID")
    private Long brandId;

    /**
     * Fecha de inicio de la validez del precio
     */
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    /**
     * Fecha de fin de la validez del precio
     */
    @Column(name="END_DATE")
    private LocalDateTime endDate;

    /**
     * Identificador de la tarifa que se aplica a un producto en n rango de fechas
     */
    @Column(name = "PRICE_LIST")
    private Long priceList;

    /**
     * Prioridad del precio aplicado
     * */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * Precio final del producto
     */
    @Column(name = "PRICE")
    private Double price;

    /**
     * Moneda en la que se expresa el precio
     * Utiliza el código ISO de la moneda (por ejemplo, 'EUR' para euros)
     */
    @Column(name = "CURR")
    private String currency;



    /**
     * GETTERS Y SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
