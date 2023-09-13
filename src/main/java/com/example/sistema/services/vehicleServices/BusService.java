package com.example.sistema.services.vehicleServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.vehiclesModels.Bus;
import com.example.sistema.repositories.vehiclesRepositories.BusRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Transactional
    public Bus create(Bus bus) {
        bus.setId(null);
        return busRepository.save(bus);
    }

    public Bus findById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        return bus.orElseThrow(() -> new ObjectNotFoundException(
                "Onibus não encontrado! Id: " + id + ", Tipo: " + Bus.class.getName()
        ));
    }

    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    public Bus update(Bus busObj) {
        Bus bus = findById(busObj.getId());

        //data not changed
        busObj.setId(bus.getId());
        busObj.setPlate(bus.getPlate());
        busObj.setChassi(bus.getChassi());
//        busObj.setManufacturingDate(bus.getManufacturingDate());
        busObj.setModel(bus.getModel());
        busObj.setStage(bus.getStage());
        busObj.setMileage(bus.getMileage());
        busObj.setWeight(bus.getWeight());
        busObj.setFuelConsumptionPerLiter(bus.getFuelConsumptionPerLiter());
        busObj.setModel(bus.getMotor());
        busObj.setPower(bus.getPower());
        busObj.setTorque(bus.getTorque());
        busObj.setTraction(bus.getTraction());
        busObj.setSunroof(bus.getSunroof());
        return busRepository.save(busObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            busRepository.deleteById(id);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }
}
