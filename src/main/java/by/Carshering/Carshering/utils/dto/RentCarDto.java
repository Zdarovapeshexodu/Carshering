package by.Carshering.Carshering.utils.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentCarDto {
    private long id;
    private long carId;
    private int time;
}
