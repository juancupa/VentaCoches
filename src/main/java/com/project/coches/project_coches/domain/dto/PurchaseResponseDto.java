package com.project.coches.project_coches.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de la consutla  de una compra
 */
public class PurchaseResponseDto {

    private Integer numberBill;
    private String carIdCustomer;
    private LocalDateTime date;
    private Double total;

    private String typePayment;
    private List<CarPurchaseResponseDto> carPurchase;
}
