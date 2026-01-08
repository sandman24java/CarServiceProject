package org.example.module3.layered.controller;

import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.repository.CarRepositoryImpl;
import org.example.module3.layered.service.CarService;
import org.example.module3.layered.service.CarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService = new CarServiceImpl(new CarRepositoryImpl());

    @GetMapping("/getcars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @GetMapping("/getcars/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getCarById(@PathVariable(name="byid") int id){
        return carService.getCarById(id);
    }

    @PostMapping("/addcar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestBody CarDto carDto){
        carService.addCar(carDto);
    }

    @PostMapping("/deletecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCar(@PathVariable(name="byid") int id){
        carService.deleteCarById(id);
    }

    @PostMapping("/updatecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCar(@PathVariable(name="byid") int id,@RequestBody CarDto carDto){
        carService.updateCar(id,carDto);
    }

}
