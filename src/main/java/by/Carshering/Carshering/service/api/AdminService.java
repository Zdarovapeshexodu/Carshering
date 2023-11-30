package by.Carshering.Carshering.service.api;

import by.Carshering.Carshering.utils.dto.CarCreationDto;
import by.Carshering.Carshering.utils.dto.CarUpdateDto;

public interface AdminService {
    void addCar(CarCreationDto carCreationDto);
    void deleteCar(long id);
    void updateCar(long id, CarUpdateDto carUpdateDto);
    void banAccountById(long accountId);

}
