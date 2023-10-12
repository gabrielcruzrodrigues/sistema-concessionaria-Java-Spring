package com.example.sistema.services;

import com.example.sistema.models.Car;
import com.example.sistema.repositories.CarRepository;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CarServiceTest {
    public static final String NAME = "Fusca";
    public static final String MANUFACTURE_YEAR = "2000";
    public static final String PLATE = "1234asd";
    public static final String COLOR = "vermelho";
    public static final String CHASSI = "123456789qwertyui";
    public static final String MODEL = "fusca";
    public static final String STAGE = "novo";
    public static final double MILEAGE = 10.500;
    public static final String WEIGHT = "1.100.000.00";
    public static final String FUEL_CONSUMPTION_PER_LITER = "6";
    public static final String MOTOR = "gasolina";
    public static final String POWER = "5500";
    public static final String TORQUE = "2.000";
    public static final boolean IS_ACTIVE = true;
    public static final boolean ELECTRIC_WINDOWS = true;
    public static final boolean AUTOMATIC_TRANSMISSION = true;
    public static final String TRACTION = "4x4";
    public static final boolean HYDRAULIC_STEERING = true;
    public static final boolean GPS = true;
    public static final boolean SUNROOF = true;
    public static final boolean SENSORS_AND_CAMERAS = true;
    public static final long ID = 1L;
    public static final String CAR_NOT_FOUND = "Carro não encontrado.";
    private Car car;
    private Car car2;
    private Optional<Car> carOptional;
    private List<Car> carList;

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCar();
    }

    @Test
    void mustReturnACarInstance_whenToCallCreate() {
        when(carRepository.save(car)).thenReturn(car);
        Car response = carService.create(car);

        assertNotNull(response);
        assertEquals(Car.class, response.getClass());
        assertEquals(NAME, response.getName());
        assertEquals(MANUFACTURE_YEAR, response.getManufactureYear());
        assertEquals(PLATE, response.getPlate());
        assertEquals(COLOR, response.getColor());
        assertEquals(CHASSI, response.getChassi());
        assertEquals(MODEL, response.getModel());
        assertEquals(STAGE, response.getStage());
        assertEquals(MILEAGE, response.getMileage());
        assertEquals(WEIGHT, response.getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getMotor());
        assertEquals(POWER, response.getPower());
        assertEquals(TORQUE, response.getTorque());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getAutomaticTransmission());
        assertEquals(TRACTION, response.getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getHydraulicSteering());
        assertEquals(GPS, response.getGps());
        assertEquals(SUNROOF, response.getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getSensorsAndCameras());
    }

    @Test
    void mustReturnAListOfTheCar_whenToCallFindAll() {
        when(carRepository.findAll()).thenReturn(carList);
        List<Car> response = carService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Car.class, response.get(0).getClass());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(MANUFACTURE_YEAR, response.get(0).getManufactureYear());
        assertEquals(PLATE, response.get(0).getPlate());
        assertEquals(COLOR, response.get(0).getColor());
        assertEquals(CHASSI, response.get(0).getChassi());
        assertEquals(MODEL, response.get(0).getModel());
        assertEquals(STAGE, response.get(0).getStage());
        assertEquals(MILEAGE, response.get(0).getMileage());
        assertEquals(WEIGHT, response.get(0).getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.get(0).getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.get(0).getMotor());
        assertEquals(POWER, response.get(0).getPower());
        assertEquals(TORQUE, response.get(0).getTorque());
        assertEquals(IS_ACTIVE, response.get(0).getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.get(0).getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.get(0).getAutomaticTransmission());
        assertEquals(TRACTION, response.get(0).getTraction());
        assertEquals(HYDRAULIC_STEERING, response.get(0).getHydraulicSteering());
        assertEquals(GPS, response.get(0).getGps());
        assertEquals(SUNROOF, response.get(0).getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.get(0).getSensorsAndCameras());
    }

    @Test
    void mustReturnACarInstance_whenToCallFindById() {
        when(carRepository.findById(anyLong())).thenReturn(carOptional);
        Car response = carService.findById(ID);

        assertNotNull(response);
        assertEquals(Car.class, response.getClass());
        assertEquals(NAME, response.getName());
        assertEquals(MANUFACTURE_YEAR, response.getManufactureYear());
        assertEquals(PLATE, response.getPlate());
        assertEquals(COLOR, response.getColor());
        assertEquals(CHASSI, response.getChassi());
        assertEquals(MODEL, response.getModel());
        assertEquals(STAGE, response.getStage());
        assertEquals(MILEAGE, response.getMileage());
        assertEquals(WEIGHT, response.getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getMotor());
        assertEquals(POWER, response.getPower());
        assertEquals(TORQUE, response.getTorque());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getAutomaticTransmission());
        assertEquals(TRACTION, response.getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getHydraulicSteering());
        assertEquals(GPS, response.getGps());
        assertEquals(SUNROOF, response.getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getSensorsAndCameras());
    }

    @Test
    void mustReturnAObjectNotFound_whenToCallFindById() {
        when(carRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(CAR_NOT_FOUND));
        try {
            carService.findById(ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(CAR_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void mustReturnACarInstanceWithoutCar2DataWithSuccess_whenToCallUpdate() {
        when(carRepository.findById(anyLong())).thenReturn(carOptional);
        when(carRepository.save(any())).thenReturn(car);
        Car response = carService.update(car2, ID);

        assertNotNull(response);
        assertEquals(Car.class, response.getClass());
        assertEquals(NAME, response.getName());
        assertEquals(MANUFACTURE_YEAR, response.getManufactureYear());
        assertEquals(PLATE, response.getPlate());
        assertEquals(COLOR, response.getColor());
        assertEquals(CHASSI, response.getChassi());
        assertEquals(MODEL, response.getModel());
        assertEquals(STAGE, response.getStage());
        assertEquals(MILEAGE, response.getMileage());
        assertEquals(WEIGHT, response.getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getMotor());
        assertEquals(POWER, response.getPower());
        assertEquals(TORQUE, response.getTorque());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getAutomaticTransmission());
        assertEquals(TRACTION, response.getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getHydraulicSteering());
        assertEquals(GPS, response.getGps());
        assertEquals(SUNROOF, response.getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getSensorsAndCameras());
    }

    @Test
    void mustReturnSuccess_whenToCallDelete() {
        doNothing().when(carRepository).deleteById(anyLong());
        when(carRepository.findById(anyLong())).thenReturn(carOptional);
        carService.delete(ID);

        verify(carRepository, times(1)).deleteById(anyLong());
    }

    void startCar() {
        car = new Car(NAME, MANUFACTURE_YEAR, PLATE, COLOR, CHASSI, MODEL, STAGE, MILEAGE, WEIGHT, FUEL_CONSUMPTION_PER_LITER, MOTOR, POWER, TORQUE,
                IS_ACTIVE, ELECTRIC_WINDOWS, AUTOMATIC_TRANSMISSION, TRACTION, HYDRAULIC_STEERING, GPS, SUNROOF, SENSORS_AND_CAMERAS);

        car2 = new Car(NAME, "2004", "4321asd", COLOR, "987654321qwertyui", "Corola", "usado", 23.000, "12.000,00", "8", MOTOR, "7000", "5000",
                IS_ACTIVE, ELECTRIC_WINDOWS, AUTOMATIC_TRANSMISSION, "2x2", HYDRAULIC_STEERING, GPS, false, SENSORS_AND_CAMERAS);


        carList = List.of(new Car(NAME, MANUFACTURE_YEAR, PLATE, COLOR, CHASSI, MODEL, STAGE, MILEAGE, WEIGHT, FUEL_CONSUMPTION_PER_LITER, MOTOR, POWER, TORQUE,
                IS_ACTIVE, ELECTRIC_WINDOWS, AUTOMATIC_TRANSMISSION, TRACTION, HYDRAULIC_STEERING, GPS, SUNROOF, SENSORS_AND_CAMERAS));

        carOptional = Optional.of(new Car(NAME, MANUFACTURE_YEAR, PLATE, COLOR, CHASSI, MODEL, STAGE, MILEAGE, WEIGHT, FUEL_CONSUMPTION_PER_LITER, MOTOR, POWER, TORQUE,
                IS_ACTIVE, ELECTRIC_WINDOWS, AUTOMATIC_TRANSMISSION, TRACTION, HYDRAULIC_STEERING, GPS, SUNROOF, SENSORS_AND_CAMERAS));
    }
}