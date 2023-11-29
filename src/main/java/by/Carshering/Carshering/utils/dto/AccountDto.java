package by.Carshering.Carshering.utils.dto;

import by.Carshering.Carshering.entity.BoughtCar;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private String login;
    private List<BoughtCarDto> boughtCarList;
    private KreditCardDto kreditCard;
}
