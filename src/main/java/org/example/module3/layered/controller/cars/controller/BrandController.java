package org.example.module3.layered.controller.cars.controller;

import jakarta.validation.Valid;
import org.example.module3.layered.dto.cars.dto.BrandDto;
import org.example.module3.layered.service.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/brands")
@Validated
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping("/getbrands")
    @ResponseStatus(HttpStatus.OK)
    public List<BrandDto> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/getbrand/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public BrandDto getBrandById(@PathVariable(name="byid") Long id){
        return brandService.getBrandById(id);
    }

    @PostMapping("/addbrand")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addBrand(@RequestBody @Valid BrandDto brandDto) {
        brandService.addBrand(brandDto);
    }

    @PutMapping("/updatebrand/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBrand(@PathVariable(name="byid") Long id,@RequestBody @Valid BrandDto brandDto){
        brandService.updateBrand(id,brandDto);
    }

    @PostMapping("/deletebrand/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBrand(@PathVariable(name="byid") Long id){
        brandService.deleteBrandById(id);
    }

}
