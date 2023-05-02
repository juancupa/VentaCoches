package com.project.coches.project_coches.domain.repository;

import com.project.coches.project_coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {



    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCarId(String carId);

    Optional<CustomerDto>getCustomerByEmail(String email);


    CustomerDto save(CustomerDto newCustomer);


    void delete (String carId);
}
