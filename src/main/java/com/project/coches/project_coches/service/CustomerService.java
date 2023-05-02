package com.project.coches.project_coches.service;

import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.dto.ResponseCustomerDto;
import com.project.coches.project_coches.domain.repository.ICustomerRepository;

import com.project.coches.project_coches.domain.useCase.ICustomerService;
import com.project.coches.project_coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {


    private final ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCarId(String carId) {
        return iCustomerRepository.getCustomerByCarId(carId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {


        System.out.printf("customer enviado");
        System.out.printf(newCustomer.toString());

        if (!newCustomer.getEmail().matches("^(?=.{1,254}$)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new EmailValidationException();
        }
        String passwordGenerated = generateRandomPasswrd(8);
        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {

        if (iCustomerRepository.getCustomerByCarId(modifyCustomer.getCarId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public boolean delete(String carId) {

        if (iCustomerRepository.getCustomerByCarId(carId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(carId);
        return true;
    }

    private String generateRandomPasswrd(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTVWXYTabcdefghigklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));

        }
        return  sb.toString();
    }
}
