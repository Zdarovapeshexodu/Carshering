package by.Carshering.Carshering.utils.dto.convertor;

import by.Carshering.Carshering.entity.KreditCard;
import by.Carshering.Carshering.utils.dto.CarCreationDto;
import by.Carshering.Carshering.utils.dto.CardCreationDto;
import by.Carshering.Carshering.utils.dto.KreditCardDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class KreditCardDtoConvertor {
    public static KreditCardDto convertEntityToDto (KreditCard source){
        return KreditCardDto.builder()
                .cardNumber(source.getCardNumber())
                .cash(source.getCash())
                .build();
    }
    public static KreditCard convertDtoToEntity (CardCreationDto source){
        return KreditCard.builder()
                .cardNumber(source.getCardNumber())
                .build();
    }
}
