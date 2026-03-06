package com.ecepolat.controller;

import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
