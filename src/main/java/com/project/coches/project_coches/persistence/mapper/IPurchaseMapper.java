package com.project.coches.project_coches.persistence.mapper;

import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.dto.PurchaseRequestDto;
import com.project.coches.project_coches.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
/*
* Mapper de compras
* */

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchasesDto(List<PurchaseEntity> purchaseEntities);

}
