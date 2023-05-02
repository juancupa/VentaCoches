package com.project.coches.project_coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad marca coche
 */
@Getter
@Setter
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<CarEntity> carEntities ;

}
