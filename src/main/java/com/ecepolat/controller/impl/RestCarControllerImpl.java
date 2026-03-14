package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestCarController;
import com.ecepolat.controller.RestBaseController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;
import com.ecepolat.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }

    @GetMapping("/get")
    @Override
    public RootEntity<List<DtoCar>> getAllCars() {
        return ok(carService.getAllCars());
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoCar> updateCar(Long id, DtoCarIU dtoCarIU) {
        return ok(carService.updateCar(id, dtoCarIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteCar(Long id) {
        return ok(carService.deleteCar(id));
    }
}
