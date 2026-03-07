package com.ecepolat.controller;

import com.ecepolat.dto.DtoSaledCar;
import com.ecepolat.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
