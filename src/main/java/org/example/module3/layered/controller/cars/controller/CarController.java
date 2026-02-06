package org.example.module3.layered.controller.cars.controller;

import jakarta.validation.Valid;
import org.example.module3.layered.dto.cars.dto.CarDto;
import org.example.module3.layered.service.car.CarService;
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

    @GetMapping("/getcars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @GetMapping("/getcar/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getCarById(@PathVariable(name="byid") Integer id){
        return carService.getCarById(id);
    }

    @PostMapping("/addcar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestParam("model-id") Integer modelId ,@RequestBody @Valid CarDto carDto) {
        carService.addCar(modelId, carDto);
    }

    @PutMapping("/updatecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCar(@PathVariable(name="byid") Integer id,@RequestBody @Valid CarDto carDto){
        carService.updateCar(id,carDto);
    }

    @PostMapping("/deletecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCar(@PathVariable(name="byid") Integer id){
        carService.deleteCarById(id);
    }

}
