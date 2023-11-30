package by.Carshering.Carshering.service;

import by.Carshering.Carshering.entity.Account;
import by.Carshering.Carshering.entity.BoughtCar;
import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.entity.KreditCard;
import by.Carshering.Carshering.repository.AccountRepository;
import by.Carshering.Carshering.repository.BoughtCarRepository;
import by.Carshering.Carshering.repository.CarRepository;
import by.Carshering.Carshering.repository.KreditCardRepository;
import by.Carshering.Carshering.security.dto.AuthRequest;
import by.Carshering.Carshering.security.dto.AuthResponse;
import by.Carshering.Carshering.service.api.AccountService;
import by.Carshering.Carshering.utils.dto.*;
import by.Carshering.Carshering.utils.dto.convertor.AccountDtoConvertor;
import by.Carshering.Carshering.utils.dto.convertor.BoughtCarDtoConvertor;
import by.Carshering.Carshering.utils.dto.convertor.KreditCardDtoConvertor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final KreditCardRepository kreditCardRepository;
    private final CarRepository carRepository;
    private final BoughtCarRepository boughtCarRepository;

    private final KreditCardServiceImpl kreditCardService;

    @Override
    public AuthResponse authentication(AuthRequest request) {
        return null;
    }

    @Override
    public AuthResponse registration(AuthRequest request) {
        return null;
    }

    @Override
    @Transactional
    public void rentCar(RentCarDto rentCarDto) throws Exception {
        Account account = accountRepository.findById(rentCarDto.getId());
        Car car = carRepository.findById(rentCarDto.getCarId());

        kreditCardService.pay(new PayDto(account.getKreditCard().getCardNumber(),car.getPrice()));

        BoughtCar boughtCar = BoughtCar.builder()
                .car(car)
                .primeTime(rentCarDto.getTime())
                .build();

        account.getBoughtCars().add(boughtCar);

        boughtCarRepository.save(boughtCar);
        accountRepository.save(account);
    }

    @Override
    public AccountDto findByName(String name) {
        return AccountDtoConvertor.convertEntityToDto(accountRepository.findByLogin(name));
    }

    @Override
    public List<BoughtCarDto> getRentedCars(String accountName) {
        return accountRepository.findByLogin(accountName).getBoughtCars().stream().map(BoughtCarDtoConvertor::convertEntityToDto).toList();
    }

    @Override
    @Transactional
    public void addCard(long id,CardCreationDto cardCreationDto) {
        Account account = accountRepository.findById(id);
        KreditCard kreditCard = KreditCardDtoConvertor.convertDtoToEntity(cardCreationDto);

        account.setKreditCard(kreditCard);

        kreditCardRepository.save(kreditCard);
        accountRepository.save(account);
    }
}
