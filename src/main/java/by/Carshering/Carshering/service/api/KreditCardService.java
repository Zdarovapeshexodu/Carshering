package by.Carshering.Carshering.service.api;

import by.Carshering.Carshering.entity.KreditCard;
import by.Carshering.Carshering.utils.dto.KreditCardDto;
import by.Carshering.Carshering.utils.dto.PayDto;

public interface KreditCardService {
    KreditCardDto getByCardNumber (String cardNumber);
    void pay(PayDto payDto) throws Exception;
    void addMoney(PayDto payDto);
}
