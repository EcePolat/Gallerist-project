package com.ecepolat.controller;

import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;

import java.util.List;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

    public RootEntity<List<DtoCar>> getAllCars();

    public RootEntity<DtoCar> updateCar(Long id, DtoCarIU dtoCarIU);

    public RootEntity<String> deleteCar(Long id);
}
