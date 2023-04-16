package com.project.coches.project_coches.persistence.maperr;


import com.project.coches.project_coches.domain.pojos.BrandCarPojo;
import com.project.coches.project_coches.persistence.entity.BrandCarEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandCarMapper {


    /**
     * convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo a convertir
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marcaEntity);

    /**
     * convierte una entidad a un pojo de marca coche
     * @param marcaCochePojo Entidad a convertir
     * @return Pojo a convertir
     */
    @InheritConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaCochePojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una
     * @param marcasCocheEntity
     * @return
     */
    List<BrandCarPojo> toMarcaCochePojo(List<BrandCarEntity>marcasCocheEntity);

}
