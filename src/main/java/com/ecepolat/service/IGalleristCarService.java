package com.ecepolat.service;

import com.ecepolat.dto.DtoGalleristCar;
import com.ecepolat.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
