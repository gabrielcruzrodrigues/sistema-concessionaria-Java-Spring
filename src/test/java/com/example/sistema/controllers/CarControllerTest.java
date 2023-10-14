package com.example.sistema.controllers;

import com.example.sistema.models.Car;
import com.example.sistema.services.CarService;
import com.fasterxml.classmate.Annotations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class CarControllerTest {
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
    private CarController carController;

    @Mock
    private CarService carService;

    @Autowired
//    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        startCar();
    }

//    @Test
//    void mustReturnResponseEntityWithACarInstanceAndStatusCodeCreated_whenToCallCreate() throws Exception {
//        when(carService.create(any(Car.class))).thenReturn(car);
//        ResponseEntity<Car> response = carController.create(car);
//
//        assertNotNull(response);
//        assertNotNull(response.getHeaders());
//        assertNotNull(response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(Car.class, response.getBody().getClass());
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(NAME, response.getBody().getName());
//        assertEquals(MANUFACTURE_YEAR, response.getBody().getManufactureYear());
//        assertEquals(PLATE, response.getBody().getPlate());
//        assertEquals(COLOR, response.getBody().getColor());
//        assertEquals(CHASSI, response.getBody().getChassi());
//        assertEquals(MODEL, response.getBody().getModel());
//        assertEquals(STAGE, response.getBody().getStage());
//        assertEquals(MILEAGE, response.getBody().getMileage());
//        assertEquals(WEIGHT, response.getBody().getWeight());
//        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getBody().getFuelConsumptionPerLiter());
//        assertEquals(MOTOR, response.getBody().getMotor());
//        assertEquals(POWER, response.getBody().getPower());
//        assertEquals(TORQUE, response.getBody().getTorque());
//        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
//        assertEquals(ELECTRIC_WINDOWS, response.getBody().getElectricWindows());
//        assertEquals(AUTOMATIC_TRANSMISSION, response.getBody().getAutomaticTransmission());
//        assertEquals(TRACTION, response.getBody().getTraction());
//        assertEquals(HYDRAULIC_STEERING, response.getBody().getHydraulicSteering());
//        assertEquals(GPS, response.getBody().getGps());
//        assertEquals(SUNROOF, response.getBody().getSunroof());
//        assertEquals(SENSORS_AND_CAMERAS, response.getBody().getSensorsAndCameras());
//    }

    @Test
    void mustReturnAResponseEntityWithAListOfTheAllCar_whenToCallGetAll() {
        when(carService.findAll()).thenReturn(carList);
        ResponseEntity<List<Car>> response = carController.getAll();

        assertNotNull(response);
        assertNotNull(response.getHeaders());
        assertNotNull(response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Car.class, response.getBody().get(0).getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(NAME, response.getBody().get(0).getName());
        assertEquals(MANUFACTURE_YEAR, response.getBody().get(0).getManufactureYear());
        assertEquals(PLATE, response.getBody().get(0).getPlate());
        assertEquals(COLOR, response.getBody().get(0).getColor());
        assertEquals(CHASSI, response.getBody().get(0).getChassi());
        assertEquals(MODEL, response.getBody().get(0).getModel());
        assertEquals(STAGE, response.getBody().get(0).getStage());
        assertEquals(MILEAGE, response.getBody().get(0).getMileage());
        assertEquals(WEIGHT, response.getBody().get(0).getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getBody().get(0).getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getBody().get(0).getMotor());
        assertEquals(POWER, response.getBody().get(0).getPower());
        assertEquals(TORQUE, response.getBody().get(0).getTorque());
        assertEquals(IS_ACTIVE, response.getBody().get(0).getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getBody().get(0).getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getBody().get(0).getAutomaticTransmission());
        assertEquals(TRACTION, response.getBody().get(0).getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getBody().get(0).getHydraulicSteering());
        assertEquals(GPS, response.getBody().get(0).getGps());
        assertEquals(SUNROOF, response.getBody().get(0).getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getBody().get(0).getSensorsAndCameras());
    }

    @Test
    void mustReturnAResponseEntityWithCarInstance_whenToCallFindById() {
        when(carService.findById(anyLong())).thenReturn(car);
        ResponseEntity<Car> response = carController.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getHeaders());
        assertNotNull(response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Car.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(MANUFACTURE_YEAR, response.getBody().getManufactureYear());
        assertEquals(PLATE, response.getBody().getPlate());
        assertEquals(COLOR, response.getBody().getColor());
        assertEquals(CHASSI, response.getBody().getChassi());
        assertEquals(MODEL, response.getBody().getModel());
        assertEquals(STAGE, response.getBody().getStage());
        assertEquals(MILEAGE, response.getBody().getMileage());
        assertEquals(WEIGHT, response.getBody().getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getBody().getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getBody().getMotor());
        assertEquals(POWER, response.getBody().getPower());
        assertEquals(TORQUE, response.getBody().getTorque());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getBody().getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getBody().getAutomaticTransmission());
        assertEquals(TRACTION, response.getBody().getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getBody().getHydraulicSteering());
        assertEquals(GPS, response.getBody().getGps());
        assertEquals(SUNROOF, response.getBody().getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getBody().getSensorsAndCameras());
    }

    @Test
    void mustReturnAResponseEntityWithCarInstance_whenToCallUpdate() {
        when(carService.update(any(), any())).thenReturn(car);
        ResponseEntity<Car> response = carController.update(car2, ID);

        assertNotNull(response);
        assertNotNull(response.getHeaders());
        assertNotNull(response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Car.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(MANUFACTURE_YEAR, response.getBody().getManufactureYear());
        assertEquals(PLATE, response.getBody().getPlate());
        assertEquals(COLOR, response.getBody().getColor());
        assertEquals(CHASSI, response.getBody().getChassi());
        assertEquals(MODEL, response.getBody().getModel());
        assertEquals(STAGE, response.getBody().getStage());
        assertEquals(MILEAGE, response.getBody().getMileage());
        assertEquals(WEIGHT, response.getBody().getWeight());
        assertEquals(FUEL_CONSUMPTION_PER_LITER, response.getBody().getFuelConsumptionPerLiter());
        assertEquals(MOTOR, response.getBody().getMotor());
        assertEquals(POWER, response.getBody().getPower());
        assertEquals(TORQUE, response.getBody().getTorque());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(ELECTRIC_WINDOWS, response.getBody().getElectricWindows());
        assertEquals(AUTOMATIC_TRANSMISSION, response.getBody().getAutomaticTransmission());
        assertEquals(TRACTION, response.getBody().getTraction());
        assertEquals(HYDRAULIC_STEERING, response.getBody().getHydraulicSteering());
        assertEquals(GPS, response.getBody().getGps());
        assertEquals(SUNROOF, response.getBody().getSunroof());
        assertEquals(SENSORS_AND_CAMERAS, response.getBody().getSensorsAndCameras());
    }

    @Test
    void mustReturnAResponseEntityWithStatusCodeOk_whenToCallDelete() {
        doNothing().when(carService).delete(anyLong());
        ResponseEntity<Object> response = carController.delete(ID);

        assertNotNull(response);
        assertNotNull(response.getHeaders());
        assertNotNull(response.getStatusCode());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
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