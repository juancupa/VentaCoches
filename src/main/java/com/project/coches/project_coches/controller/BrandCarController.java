package com.project.coches.project_coches.controller;


import com.project.coches.project_coches.domain.pojos.BrandCarPojo;
import com.project.coches.project_coches.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {


    private final IBrandCarService iBrandCarService;

    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        return ResponseEntity.ok(iBrandCarService.getAll());
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){

        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping()
    public ResponseEntity<BrandCarPojo>save(@RequestBody BrandCarPojo brandCarPojonew  ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojonew));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
}

@PutMapping()
public  ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){

    return ResponseEntity.status(HttpStatus.OK)
            .body(iBrandCarService.save(brandCarPojoUpdate));
}

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Boolean> delete (@PathVariable Integer id){

    return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND  );
}

}
