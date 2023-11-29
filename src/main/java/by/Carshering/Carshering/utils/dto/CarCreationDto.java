package by.Carshering.Carshering.utils.dto;

import by.Carshering.Carshering.utils.enumirations.Brend;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCreationDto {
    private String brend;
    private String location;
    private double price;
    private String model;
}
