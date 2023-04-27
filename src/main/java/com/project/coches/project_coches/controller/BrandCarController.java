package com.project.coches.project_coches.controller;


import com.project.coches.project_coches.domain.dto.BrandCarDto;
import com.project.coches.project_coches.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {


    private final IBrandCarService iBrandCarService;

    @GetMapping()
    public ResponseEntity<List<BrandCarDto>> getAll(){
        return ResponseEntity.ok(iBrandCarService.getAll());
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id){

        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping()
    public ResponseEntity<BrandCarDto>save(@RequestBody BrandCarDto brandCarPojonew  ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojonew));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
}

@PatchMapping()
public  ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate){

    BrandCarDto brandCarDto = iBrandCarService.update(brandCarDtoUpdate);
    if(brandCarDto == null){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }else {
        return ResponseEntity.status(HttpStatus.OK)
                .body(brandCarDto);
        }
    }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Boolean> delete (@PathVariable Integer id){

    return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND  );
}

}
