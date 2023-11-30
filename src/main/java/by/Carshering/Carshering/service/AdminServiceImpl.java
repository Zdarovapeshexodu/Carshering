package by.Carshering.Carshering.service;

import by.Carshering.Carshering.entity.Account;
import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.repository.AccountRepository;
import by.Carshering.Carshering.repository.CarRepository;
import by.Carshering.Carshering.service.api.AdminService;
import by.Carshering.Carshering.utils.dto.CarCreationDto;
import by.Carshering.Carshering.utils.dto.CarUpdateDto;
import by.Carshering.Carshering.utils.dto.convertor.CarDtoConvertor;
import by.Carshering.Carshering.utils.enumirations.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final CarRepository carRepository;
    private final AccountRepository accountRepository;

    @Override
    public void addCar(CarCreationDto carCreationDto) {
        Car car = CarDtoConvertor.convertDtoToEntity(carCreationDto);

        carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(long id, CarUpdateDto carUpdateDto) {
        Car car = carRepository.findById(id);

        if (carUpdateDto.getLocation()!= null)
            car.setLocation(carUpdateDto.getLocation());
        if (carUpdateDto.getPrice()!= 0)
            car.setPrice(carUpdateDto.getPrice());

        carRepository.save(car);
    }

    @Override
    public void banAccountById(long accountId) {
        Account account = accountRepository.findById(accountId);

        account.setRole(Role.ROLE_BANNED);

        accountRepository.save(account);
    }
}
