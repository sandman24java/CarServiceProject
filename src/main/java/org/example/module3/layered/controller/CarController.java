package org.example.module3.layered.controller;

import jakarta.validation.Valid;
import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.service.CarService;
import org.example.module3.layered.validation.BrandGroupA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/cars")
@Validated
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/getbrands")
    @ResponseStatus(HttpStatus.OK)
    public List<BrandDto> getBrands() {
        return carService.getBrands();
    }

    @GetMapping("/getbrand/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public BrandDto getBrandById(@PathVariable(name="byid") Integer id){
        return carService.getBrandById(id);
    }

    @PostMapping("/addbrand")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addBrand(@RequestBody @Valid BrandDto brandDto) {
        carService.addBrand(brandDto);
    }




//    @PostMapping("/addbrand")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void addBrands(@RequestBody  BrandDto brandDto){
//        carService.addBrand(brandDto);
//    }
//
//    @PostMapping("/addcar")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void addCar(@RequestBody CarDto carDto){
//        carService.addCar(carDto);
//    }
//
//    @PostMapping("/deletecar/{byid}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void deleteCar(@PathVariable(name="byid") int id){
//        carService.deleteCarById(id);
//    }
//
//    @PostMapping("/updatecar/{byid}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateCar(@PathVariable(name="byid") int id,@RequestBody CarDto carDto){
//        carService.updateCar(id,carDto);
//    }

}
