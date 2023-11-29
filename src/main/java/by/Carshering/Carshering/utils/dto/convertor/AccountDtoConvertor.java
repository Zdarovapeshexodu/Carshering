package by.Carshering.Carshering.utils.dto.convertor;

import by.Carshering.Carshering.entity.Account;
import by.Carshering.Carshering.utils.dto.AccountDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountDtoConvertor {
    public static AccountDto convertEntityToDto(Account source){
        return AccountDto.builder()
                .login(source.getLogin())
                .kreditCard(KreditCardDtoConvertor.convertEntityToDto(source.getKreditCard()))
                .boughtCarList(source.getBoughtCars().stream().map(BoughtCarDtoConvertor::convertEntityToDto).toList())
                .build();
    }
}
