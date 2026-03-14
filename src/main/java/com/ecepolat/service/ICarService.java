package com.ecepolat.service;

import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;

import java.util.List;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);

    public List<DtoCar> getAllCars();

    public DtoCar updateCar(Long id, DtoCarIU dtoCarIU);

    public String deleteCar(Long id);
}
