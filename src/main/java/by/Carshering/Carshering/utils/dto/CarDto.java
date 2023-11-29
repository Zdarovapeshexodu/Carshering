package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String brend;
    private String location;
    private double price;
    private String model;
}
