package com.project.coches.project_coches.persistence.entity;

import com.project.coches.project_coches.domain.dto.CarPurchaseResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;
    @Column(name = "cliente_cedula")
    private String carIdCustomer;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(name = "total")
    private Double total;
    @Column(name = "medio_pago")
    private String typePayment;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carsPurchase;
}
