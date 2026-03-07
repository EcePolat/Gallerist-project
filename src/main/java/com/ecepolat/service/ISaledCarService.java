package com.ecepolat.service;

import com.ecepolat.dto.DtoSaledCar;
import com.ecepolat.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
