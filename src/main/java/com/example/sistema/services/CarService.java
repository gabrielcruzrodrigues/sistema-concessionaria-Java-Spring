package com.example.sistema.services;

import com.example.sistema.models.Car;
import com.example.sistema.repositories.CarRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Transactional
    public Car create(Car carObj) {
        carObj.setId(null);
        return carRepository.save(carObj);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Transactional
    public Car findById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() -> new ObjectNotFoundException(
                "Onibus não encontrado! Id:" + id + ", Tipo: " + Car.class.getName()
        ));
    }

    public Car update(Car carObj) {
        Car car = findById(carObj.getId());

        //data not changed
        carObj.setId(car.getId());
        carObj.setManufacture_year(car.getManufacture_year());
        carObj.setPlate(car.getPlate());
        carObj.setChassi(car.getChassi());
        carObj.setModel(car.getModel());
        carObj.setStage(car.getStage());
        carObj.setMileage(car.getMileage());
        carObj.setWeight(car.getWeight());
        carObj.setFuelConsumptionPerLiter(car.getFuelConsumptionPerLiter());
        carObj.setModel(car.getMotor());
        carObj.setPower(car.getPower());
        carObj.setTorque(car.getTorque());
        carObj.setTraction(car.getTraction());
        carObj.setSunroof(car.getSunroof());
        return carRepository.save(carObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            carRepository.deleteById(id);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }

    @Transactional
    public void setNotActive(Long id) {
        Car car = findById(id);
        car.setIsActive(false);
        update(car);
    }
}
