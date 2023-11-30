package by.Carshering.Carshering.service;

import by.Carshering.Carshering.entity.Account;
import by.Carshering.Carshering.entity.BoughtCar;
import by.Carshering.Carshering.repository.AccountRepository;
import by.Carshering.Carshering.repository.BoughtCarRepository;
import by.Carshering.Carshering.service.api.BoughtCarService;
import by.Carshering.Carshering.utils.dto.BoughtCarDto;
import by.Carshering.Carshering.utils.dto.convertor.BoughtCarDtoConvertor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoughtCarServiceImpl implements BoughtCarService {
    private final AccountRepository accountRepository;
    private final BoughtCarRepository boughtCarRepository;

    @Override
    public BoughtCarDto findById(long id) {
        return BoughtCarDtoConvertor.convertEntityToDto(boughtCarRepository.findById(id));
    }

    @Override
    @Transactional
    public void cancel(long accountId, long carId) {
        Account account = accountRepository.findById(accountId);
        BoughtCar boughtCar = boughtCarRepository.findById(carId);

        account.getKreditCard().setCash(account.getKreditCard().getCash()+boughtCar.getCar().getPrice()*0.7);
        account.getBoughtCars().remove(boughtCar);

        boughtCarRepository.deleteById(carId);

        accountRepository.save(account);
    }
}
