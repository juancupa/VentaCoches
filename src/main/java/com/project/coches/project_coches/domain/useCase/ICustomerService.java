package com.project.coches.project_coches.domain.useCase;

import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCarId(String carId);

    Optional<CustomerDto>getCustomerByEmail(String email);


    ResponseCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto>update (CustomerDto modifyCustomer);


    boolean delete (String carId);
}
