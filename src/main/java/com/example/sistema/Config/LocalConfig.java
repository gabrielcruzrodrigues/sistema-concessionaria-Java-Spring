package com.example.sistema.Config;

import com.example.sistema.models.Car;
import com.example.sistema.repositories.CarRepository;
import com.example.sistema.services.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Bean
    public void initializeDatabaseWithSampleDataCar() throws ParseException {
        List<Car> sampleCar = createSamplePeople();
        carRepository.saveAll(sampleCar);
    }


//    @Bean
//    public void initializeDatabaseWithSampleData

    private List<Car> createSamplePeople() throws ParseException {
        return List.of(
                new Car("Fusca", "2000", "1234asd", "vermelho", "123456789qwertyui", "fusca",
                        "novo", 10.500, "1.100.000.00","6", "gasolina",
                        "5500", "2.000", true, true, true,
                        "4x4", true, true, true, true),

                new Car("Mustang GT", "2000", "asdf123", "azul", "123456789poiuytre", "mustang",
                        "novo", 20.500, "1.300.000.00", "4", "disel",
                        "5200", "2.250", true, true, false,
                        "2x2", true, true, true, true),

                new Car("Corsa", "2016", "123lksd", "verde", "321456789qwertyui", "corsa",
                        "usado", 10.500, "1.100.000.00", "6", "alcool",
                        "5500", "2.000", true, true, false,
                        "4x4", true, false, true, true),

                new Car("Camaro", "2015","1654ksd", "amarelo", "321456712345rtyui", "camaro",
                        "novo", 10.500, "1.100.000.00", "6", "alcool",
                        "5500", "2.000", true, true, false,
                        "4x4", true, false, true, true),

                new Car("Bmw", "2023","1654khd", "branca", "321456712345rty12", "bmw",
                        "novo", 10.500, "1.100.000.00", "6", "alcool",
                        "5500", "2.000", true, true, false,
                        "4x4", true, false, true, true)
        );
    }
}
