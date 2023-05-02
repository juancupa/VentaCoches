package com.project.coches.project_coches.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter @Setter
@Embeddable
public class CarPurchasePK implements Serializable {

    //private static final long seralVersionUID =
    @Column( name = "compras_numero_factura")
    private Integer purchaseNumberBill;
    @Column(name = "coches_codigo_coches")
    private Integer codeCar;



}
