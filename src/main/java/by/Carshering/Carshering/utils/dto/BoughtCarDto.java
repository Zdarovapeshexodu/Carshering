package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoughtCarDto {
    private CarDto car;
    private int primeTime;

}
