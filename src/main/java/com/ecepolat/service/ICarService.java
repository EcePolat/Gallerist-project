package com.ecepolat.service;

import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
