package com.ecepolat.controller;

import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;

import java.util.List;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);

    public RootEntity<List<DtoGallerist>> getAllGallerist();

    public RootEntity<DtoGallerist> updateGallerist(Long id, DtoGalleristIU dtoGalleristIU);

    public RootEntity<String> deleteGallerist(Long id);
}
