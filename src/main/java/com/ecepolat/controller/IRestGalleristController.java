package com.ecepolat.controller;

import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
