package com.project.coches.project_coches.persistence.mapper;


import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    @Mapping(target = "purchaseEntity", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);


}
