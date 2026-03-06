package com.ecepolat.controller;

import com.ecepolat.dto.DtoGalleristCar;
import com.ecepolat.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
