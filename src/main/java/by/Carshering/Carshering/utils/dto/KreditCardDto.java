package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KreditCardDto {
    private String cardNumber;
    private double cash;
}
