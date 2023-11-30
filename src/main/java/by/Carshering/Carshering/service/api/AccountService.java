package by.Carshering.Carshering.service.api;

import by.Carshering.Carshering.entity.BoughtCar;
import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.security.dto.AuthRequest;
import by.Carshering.Carshering.security.dto.AuthResponse;
import by.Carshering.Carshering.utils.dto.AccountDto;
import by.Carshering.Carshering.utils.dto.BoughtCarDto;
import by.Carshering.Carshering.utils.dto.CardCreationDto;
import by.Carshering.Carshering.utils.dto.RentCarDto;

import java.util.List;

public interface AccountService {
    AuthResponse authentication(AuthRequest request);
    AuthResponse registration(AuthRequest request);
    void rentCar(RentCarDto rentCarDto) throws Exception;
    AccountDto findByName(String name);
    List<BoughtCarDto> getRentedCars(String accountName);
    void addCard(long id, CardCreationDto cardCreationDto);
}
