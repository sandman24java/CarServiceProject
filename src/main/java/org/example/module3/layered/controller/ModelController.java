package org.example.module3.layered.controller;

import jakarta.validation.Valid;
import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.dto.ModelDto;
import org.example.module3.layered.service.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@Validated
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }

    @GetMapping("/getmodels")
    @ResponseStatus(HttpStatus.OK)
    public List<ModelDto> getModels() {
        return modelService.getModels();
    }

    @GetMapping("/getmodel/{byid}")
    @ResponseStatus(HttpStatus.OK)
    public ModelDto getModelById(@PathVariable(name="byid") Integer id){
        return modelService.getModelById(id);
    }

    @PostMapping("/addmodel")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addModel(@RequestParam("brand-id") Long brandId, @RequestBody @Valid ModelDto modelDto) {
        modelService.addModel(brandId, modelDto);
    }

    @PutMapping("/updatemodel/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateModel(@PathVariable(name="byid") Integer id,@RequestBody @Valid ModelDto modelDto){
        modelService.updateModel(id,modelDto);
    }

    @PostMapping("/deletemodel/{byid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteModel(@PathVariable(name="byid") Integer id){
        modelService.deleteModelById(id);
    }

}
