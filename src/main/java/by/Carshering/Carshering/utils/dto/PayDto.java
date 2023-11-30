package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayDto {
    private String cardNumber;
    private double cash;
}
