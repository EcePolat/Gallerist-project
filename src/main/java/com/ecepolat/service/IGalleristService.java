package com.ecepolat.service;

import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;

import java.util.List;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);

    public List<DtoGallerist> getAllGallerists();

    public DtoGallerist updateGallerist(Long id, DtoGalleristIU dtoGalleristIU);

    public String deleteGallerist(Long id);
}
