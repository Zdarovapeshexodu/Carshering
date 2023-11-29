package by.Carshering.Carshering.utils.dto.convertor;

import by.Carshering.Carshering.entity.BoughtCar;
import by.Carshering.Carshering.utils.dto.BoughtCarDto;

public class BoughtCarDtoConvertor {
    public static BoughtCarDto convertEntityToDto (BoughtCar source){
        return BoughtCarDto.builder()
                .car(CarDtoConvertor.convertEntityToDto(source.getCar()))
                .primeTime(source.getPrimeTime())
                .build();
    }
}
