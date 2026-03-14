package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestGalleristController;
import com.ecepolat.controller.RestBaseController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;
import com.ecepolat.service.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }

    @GetMapping("/get")
    @Override
    public RootEntity<List<DtoGallerist>> getAllGallerist() {
        return ok(galleristService.getAllGallerists());
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoGallerist> updateGallerist(@PathVariable Long id,
                                                    @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.updateGallerist(id, dtoGalleristIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteGallerist(@PathVariable Long id) {
        return ok(galleristService.deleteGallerist(id));
    }
}
