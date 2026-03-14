package com.ecepolat.service.impl;

import com.ecepolat.dto.DtoAddress;
import com.ecepolat.dto.DtoGallerist;
import com.ecepolat.dto.DtoGalleristIU;
import com.ecepolat.exception.BaseException;
import com.ecepolat.exception.ErrorMessage;
import com.ecepolat.exception.MessageType;
import com.ecepolat.model.Address;
import com.ecepolat.model.Gallerist;
import com.ecepolat.repository.AddressRepository;
import com.ecepolat.repository.GalleristRepository;
import com.ecepolat.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU){
        Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
        }

        Gallerist gallerist = new Gallerist();
        gallerist.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(optAddress.get());

        return gallerist;
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);

        return dtoGallerist;
    }

    @Override
    public List<DtoGallerist> getAllGallerists() {

        List<Gallerist> galleristList = galleristRepository.findAll();
        List<DtoGallerist> dtoList = new ArrayList<>();

        for (Gallerist gallerist : galleristList){
            DtoGallerist dtoGallerist = new DtoGallerist();
            BeanUtils.copyProperties(gallerist, dtoGallerist);

            dtoList.add(dtoGallerist);
        }
        return dtoList;
    }

    @Override
    public DtoGallerist updateGallerist(Long id, DtoGalleristIU dtoGalleristIU) {

        Optional<Gallerist> optGallerist = galleristRepository.findById(id);

        if (optGallerist.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        Gallerist gallerist = optGallerist.get();

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);

        Gallerist updatedGallerist = galleristRepository.save(gallerist);

        DtoGallerist dtoGallerist = new DtoGallerist();

        BeanUtils.copyProperties(updatedGallerist, dtoGallerist);

        return dtoGallerist;
    }

    @Override
    public String deleteGallerist(Long id) {

        Optional<Gallerist> optGallerist = galleristRepository.findById(id);

        if (optGallerist.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        galleristRepository.delete(optGallerist.get());

        return "Gallerist is deleted successfully";
    }
}
