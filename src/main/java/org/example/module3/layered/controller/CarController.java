package org.example.module3.layered.controller;
import org.example.module3.layered.config.ProfileConfig;
import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.exception.base.BaseErrorResponseDTO;
import org.example.module3.layered.exception.base.BaseException;
import org.example.module3.layered.repository.CarRepositoryImpl;
import org.example.module3.layered.service.CarService;
import org.example.module3.layered.service.CarServiceImplForDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final ProfileConfig config;

    @Value("${app.show-history}")
    private String nameFromProfileAsValue;

    @Autowired
    public CarController(ProfileConfig config, CarService carService){
        this.config = config;
        this.carService = carService;
    }

    @GetMapping("/info")
    public String getAppInfo() {
        return "App is working in following mode: " + config.getEnv() + " and show history is " + nameFromProfileAsValue;
    }


    @GetMapping("/getcars")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @GetMapping("/getcars/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getCarById(@PathVariable(name = "byid") int id) {
        return carService.getCarById(id);
    }

    @PostMapping("/addcar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PostMapping("/deletecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCar(@PathVariable(name = "byid") int id) {
        carService.deleteCarById(id);
    }

    @PostMapping("/updatecar/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCar(@PathVariable(name = "byid") int id, @RequestBody CarDto carDto) {
        carService.updateCar(id, carDto);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseErrorResponseDTO> handleCarException(BaseException ex,
                                                                   WebRequest webRequest) {
        return new ResponseEntity<>(new BaseErrorResponseDTO(
                ex.baseErrorService.getErrorCode(),
                ex.baseErrorService.getMessage(),
                webRequest.getContextPath(),
                LocalDateTime.now().toString(),
                ex.baseErrorService.getHttpStatus()),
                HttpStatusCode.valueOf(ex.baseErrorService.getHttpStatus())
        );

    }
}
