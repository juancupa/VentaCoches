package com.project.coches.project_coches.controller;


import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.dto.ResponseCustomerDto;


import com.project.coches.project_coches.domain.useCase.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerService.getAll());
    }


    @GetMapping(path = "/{carId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String carId){
        return ResponseEntity.of(iCustomerService.getCustomerByCarId(carId));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<ResponseCustomerDto>save(@RequestBody CustomerDto customerDto  ) {

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerService.save(customerDto));

    }

    @PatchMapping()
    public  ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate){

        return ResponseEntity.of(iCustomerService.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "/{carId}")
    public  ResponseEntity<Boolean> delete (@PathVariable String carId){

        return new ResponseEntity<>(this.iCustomerService.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND  );
    }
}
