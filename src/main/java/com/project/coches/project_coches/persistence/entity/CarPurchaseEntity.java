package com.project.coches.project_coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {


    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantity;
    private Integer total;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name ="compras_numero_factura", insertable = false, updatable = false )
    private  PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name ="coches_codigo_coches", insertable = false, updatable = false )
    private CarEntity carEntity;
}
