package com.project.coches.project_coches.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private String carId;
    @Column(name = "Nombre_completo")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "Numero_celular")
    private  String numberCellphone;
    @Column(name = "activo")
    private Integer active;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntity;


}
