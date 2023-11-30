package by.Carshering.Carshering.service;

import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.repository.CarRepository;
import by.Carshering.Carshering.service.api.CarService;
import by.Carshering.Carshering.utils.dto.CarDto;
import by.Carshering.Carshering.utils.dto.convertor.CarDtoConvertor;
import by.Carshering.Carshering.utils.enumirations.Brend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public CarDto findById(long id) {
        return CarDtoConvertor.convertEntityToDto(carRepository.findById(id));
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream().map(CarDtoConvertor::convertEntityToDto).toList();
    }

    @Override
    public List<CarDto> searchByBrend(Brend brend) {
        return carRepository.findByBrendLike(brend).stream().map(CarDtoConvertor::convertEntityToDto).toList();
    }

    @Override
    public List<CarDto> searchByModel(String model) {
        return carRepository.findByModelLike(model).stream().map(CarDtoConvertor::convertEntityToDto).toList();
    }
}
