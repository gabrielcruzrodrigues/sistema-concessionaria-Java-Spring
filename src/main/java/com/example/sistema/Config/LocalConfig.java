package com.example.sistema.Config;

import com.example.sistema.models.Car;
import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.repositories.CarRepository;
import com.example.sistema.repositories.personRepositories.ClientRepository;
import com.example.sistema.repositories.personRepositories.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.example.sistema.util.FormatData;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Bean
    public void initializeDatabaseWithSampleDataCar() throws ParseException {
        List<Car> sampleCar = createSampleCars();
        carRepository.saveAll(sampleCar);
    }

    @Bean
    public void initializeDatabaseWithSampleDataClient() throws ParseException{
        List<Client> sampleClient = createSampleClient();
        clientRepository.saveAll(sampleClient);
    }

    @Bean
    public void initializeDatabaseWithSampleDataSeller() throws ParseException {
        List<Seller> sampleSeller = createSampleSeller();
        sellerRepository.saveAll(sampleSeller);
    }


    private List<Car> createSampleCars() throws ParseException {
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

    private List<Client> createSampleClient() throws ParseException{
        return List.of(
                new Client(null, "Gabriel Rodrigues", FormatData.formatDate("12/05/2002"), "503.851.790-06", "Rua Almeida",
                        "33900000000", "gabriel@gmail.com", "BR", true, 20.000, 7000.000, true),
                new Client(null, "David Sampan", FormatData.formatDate("24/08/1995"), "213.850.860-92", "Rua Rio Niteroi",
                        "33988888888", "David@gmail.com", "BR", true, 0.0, 5000.000, false)
        );
    }

    private List<Seller> createSampleSeller() throws ParseException {
        return List.of(
                new Seller(null, "Gabriel Rodrigues", FormatData.formatDate("12/05/2002"), "503.851.790-06", "Rua Almeida",
                        "33900000000", "gabriel@gmail.com", "BR", true, "comercial", "vendas",
                        "9:00-18:00", 5000.0, false, 50, 5, 200.0, "Jequié"),
                new Seller(null, "André Morais", FormatData.formatDate("26/01/2000"), "758.748.750-69", "Rua Girassol",
                        "33988884444", "andre@gmail.com", "BR", true, "comercial", "vendas",
                        "9:00-18:00", 6000.0, true, 60, 7, 400000.0, "Jitaúna")
        );
    }
}
