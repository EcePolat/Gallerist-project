package com.ecepolat.service;

import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
