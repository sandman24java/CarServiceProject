package org.example.module3.service;


import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.CarEntity;
import org.example.module3.layered.repository.CarRepository;
import org.example.module3.layered.service.CarServiceImplForDev;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplForDevTest {
    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarServiceImplForDev carServiceImplForDev;



    @Test
    public void getCarByIdSuccess() {
        Mockito.when(carRepository.getCarById(Mockito.anyInt()))
                .thenReturn(Optional.of(new CarEntity("Ferrari",200,"Red")));
        CarDto carDtoActual = carServiceImplForDev.getCarById(1);
        CarDto carDtoExpected = new CarDto("Ferrari",200,"Red");
        Assertions.assertEquals(carDtoExpected.name(),carDtoActual.name());
        Assertions.assertEquals(carDtoExpected.speed(),carDtoActual.speed());
        Assertions.assertEquals(carDtoExpected.color(),carDtoActual.color());
    }
    @Test
    public void getCarByIdFail() {
        Mockito.when(carRepository.getCarById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(CarException.class,()-> carServiceImplForDev.getCarById(1));
    }
    @Test
    void getCarById_throw(){
        Mockito.when(carRepository.getCarById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(CarException.class,()-> carServiceImplForDev.getCarById(1));
    }
    @Test
    void getCarsTest(){
        Mockito.when(carRepository.getCars()).thenReturn(List.of(new CarEntity("Red",100,"Ferrari")));
        List<CarDto> actualList = carServiceImplForDev.getCars();
        List<CarDto> expectedList = List.of(new CarDto("Red",100,"Ferrari"));
        Assertions.assertEquals(actualList.get(0).speed(),expectedList.get(0).speed());
        Assertions.assertEquals(actualList.get(0).color(),expectedList.get(0).color());
    }
    // Если метод войд то: есть метод .verify он спрашивает у метода сервиса:
    // Ты вызывал метод моего мока? И с теми же полями или нет?
    @Test
    void addCarTest(){
        CarDto carDto = new CarDto("Red",100,"Ferrari");
        carServiceImplForDev.addCar(carDto);
        Mockito.verify(carRepository).saveCar(new CarEntity("Red",100,"Ferrari"));
    }
    @Test
    void updateCarTestIdExists(){
        CarDto carDto = new CarDto("Red",100,"Ferrari");
        carServiceImplForDev.updateCar(1,carDto);
        Mockito.verify(carRepository).updateCar(1,new CarEntity("Red",100,"Ferrari"));
    }
    @Test
    void deleteCarByIdTest(){
        carServiceImplForDev.deleteCarById(1);
        Mockito.verify(carRepository).deleteCarById(1);
    }





}
