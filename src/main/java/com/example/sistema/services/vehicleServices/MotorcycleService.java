package com.example.sistema.services.vehicleServices;

import com.example.sistema.models.vehiclesModels.Motorcycle;
import com.example.sistema.repositories.vehiclesRepositories.MotorcycleRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Transactional
    public Motorcycle create(Motorcycle motorcycle) {
        motorcycle.setId(null);
        return motorcycleRepository.save(motorcycle);
    }

    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle findById(Long id) {
        Optional<Motorcycle> motorcycle = motorcycleRepository.findById(id);
        return motorcycle.orElseThrow(() -> new ObjectNotFoundException(
                "Moto não encontrada! Id:" + id + ", Tipo: " + Motorcycle.class.getName()
        ));
    }

    @Transactional
    public Motorcycle update(Motorcycle motorcycleObj) {
        Motorcycle motorcycle = findById(motorcycleObj.getId());

        //data not changed
        motorcycleObj.setId(motorcycle.getId());
        motorcycleObj.setPlate(motorcycle.getPlate());
        motorcycleObj.setChassi(motorcycle.getChassi());
//        motorcycleObj.setManufacturingDate(motorcycle.getManufacturingDate());
        motorcycleObj.setModel(motorcycle.getModel());
        motorcycleObj.setStage(motorcycle.getStage());
        motorcycleObj.setMileage(motorcycle.getMileage());
        motorcycleObj.setWeight(motorcycle.getWeight());
        motorcycleObj.setFuelConsumptionPerLiter(motorcycle.getFuelConsumptionPerLiter());
        motorcycleObj.setModel(motorcycle.getMotor());
        motorcycleObj.setPower(motorcycle.getPower());
        motorcycleObj.setTorque(motorcycle.getTorque());

        return motorcycleRepository.save(motorcycleObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            motorcycleRepository.deleteById(id);
        }catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }
}
