package com.project.coches.project_coches.controller;

import com.project.coches.project_coches.domain.dto.CarDto;
import com.project.coches.project_coches.domain.dto.CustomerDto;
import com.project.coches.project_coches.domain.dto.ResponseCustomerDto;
import com.project.coches.project_coches.domain.useCase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "cars")
public class CarController {

    private final ICarService iCarService;

/*
    @GetMapping()
    public ResponseEntity<List<CarDto>> getAll(){

        return ResponseEntity.ok(iCarService.getAll());
    }*/

    @GetMapping(path = "/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getByIdBrandCar(@PathVariable Integer idBrandCar){
        return ResponseEntity.ok(iCarService.getByIdBrandCar(idBrandCar));
    }

    @GetMapping(path = "/price/{priceCar}")
    public ResponseEntity<List<CarDto>> getCartByPriceLessThan(@PathVariable Double priceCar){
        return ResponseEntity.ok(iCarService.getCartByPriceLessThan(priceCar));
    }

    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar){
        return ResponseEntity.of(iCarService.getCar(idCar));
    }

    @PostMapping()
    public ResponseEntity<CarDto>save(@RequestBody CarDto CarDto  ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarService.save(CarDto));

    }

    @DeleteMapping(path = "/{carId}")
    public  ResponseEntity<Boolean> delete (@PathVariable Integer carId){

        return new ResponseEntity<>(this.iCarService.delete(carId) ? HttpStatus.OK : HttpStatus.NOT_FOUND  );
    }
}
