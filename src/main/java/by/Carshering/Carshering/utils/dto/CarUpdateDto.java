package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CarUpdateDto {
    private String location;
    private double price;
}
