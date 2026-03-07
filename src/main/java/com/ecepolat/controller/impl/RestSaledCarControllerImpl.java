package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestSaledCarController;
import com.ecepolat.controller.RestBaseController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.DtoSaledCar;
import com.ecepolat.dto.DtoSaledCarIU;
import com.ecepolat.service.ISaledCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements IRestSaledCarController {

    @Autowired
    private ISaledCarService saledCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.buyCar(dtoSaledCarIU));
    }
}
