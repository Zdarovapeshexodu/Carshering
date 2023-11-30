package by.Carshering.Carshering.controller;

import by.Carshering.Carshering.service.api.CarService;
import by.Carshering.Carshering.utils.dto.CarDto;
import by.Carshering.Carshering.utils.dto.convertor.CarDtoConvertor;
import by.Carshering.Carshering.utils.enumirations.Brend;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public CarDto findById(@PathVariable long id){
        return carService.findById(id);
    }

    @GetMapping
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/searchBrend/{brend}")
    public List<CarDto> searchByBrend(@PathVariable String brend) {
        return carService.searchByBrend(Brend.valueOf(brend));
    }

    @GetMapping("/searchModel/{model}")
    public List<CarDto> searchByModel(@PathVariable String model) {
        return carService.searchByModel(model);
    }
}
