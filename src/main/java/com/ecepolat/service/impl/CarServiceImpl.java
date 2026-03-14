package com.ecepolat.service.impl;

import com.ecepolat.dto.DtoCar;
import com.ecepolat.dto.DtoCarIU;
import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.exception.BaseException;
import com.ecepolat.exception.ErrorMessage;
import com.ecepolat.exception.MessageType;
import com.ecepolat.model.Car;
import com.ecepolat.model.Customer;
import com.ecepolat.repository.CarRepository;
import com.ecepolat.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU){
        Car car = new Car();
        car.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(dtoCarIU));

        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }

    @Override
    public List<DtoCar> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<DtoCar> dtoList = new ArrayList<>();

        for (Car car : carList){
            DtoCar dtoCar = new DtoCar();
            BeanUtils.copyProperties(car, dtoCar);

            dtoList.add(dtoCar);
        }
        return dtoList;
    }

    @Override
    public DtoCar updateCar(Long id, DtoCarIU dtoCarIU) {
        Optional<Car> optCar = carRepository.findById(id);

        if (optCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        Car car = optCar.get();

        BeanUtils.copyProperties(dtoCarIU, car);

        Car updatedCar = carRepository.save(car);

        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(updatedCar, dtoCar);

        return dtoCar;
    }

    @Override
    public String deleteCar(Long id) {
        Optional<Car> optCar = carRepository.findById(id);

        if (optCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        carRepository.delete(optCar.get());
        return "Car is deleted successfully.";
    }
}
