package com.project.coches.project_coches.persistence.repository;

import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.repository.ICustomerRepository;
import com.project.coches.project_coches.persistence.crud.ICustomerCrudRepository;
import com.project.coches.project_coches.persistence.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;
    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }


    public Optional<CustomerDto> getCustomerByCarId(String carId) {
        return iCustomerCrudRepository.findById(carId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository
                .save(iCustomerMapper.toCustomerEntity(newCustomer)));
    }

    @Override
    public void delete(String carId) {
        iCustomerCrudRepository.deleteById(carId);

    }


}
