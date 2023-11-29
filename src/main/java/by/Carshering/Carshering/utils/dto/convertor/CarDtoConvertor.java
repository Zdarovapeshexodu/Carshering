package by.Carshering.Carshering.utils.dto.convertor;

import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.utils.dto.CarCreationDto;
import by.Carshering.Carshering.utils.dto.CarDto;
import by.Carshering.Carshering.utils.enumirations.Brend;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarDtoConvertor {
    public static CarDto convertEntityToDto(Car source){
        return CarDto.builder()
                .brend(source.getBrend().toString())
                .location(source.getLocation())
                .model(source.getModel())
                .price(source.getPrice())
                .build();

    }
    public static Car convertDtoToEntity(CarCreationDto source){
        return Car.builder()
                .brend(Brend.valueOf(source.getBrend()))
                .price(source.getPrice())
                .model(source.getModel())
                .location(source.getLocation())
                .build();
    }

}
