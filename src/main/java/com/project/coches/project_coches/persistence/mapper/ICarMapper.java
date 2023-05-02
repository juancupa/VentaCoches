package com.project.coches.project_coches.persistence.mapper;

import com.project.coches.project_coches.domain.dto.CarDto;
import com.project.coches.project_coches.persistence.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {


    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "carPurchaseEntity", ignore = true)
    @Mapping(target = "brandCarEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDto(List<CarEntity> carEntityList);

}
