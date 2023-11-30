package by.Carshering.Carshering.service.api;

import by.Carshering.Carshering.utils.dto.CarDto;
import by.Carshering.Carshering.utils.enumirations.Brend;

import java.util.List;

public interface CarService {
    CarDto findById (long id);
    List<CarDto> findAll();
    List<CarDto> searchByBrend(Brend brend);
    List<CarDto> searchByModel (String model);
}
