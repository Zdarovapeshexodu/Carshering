package by.Carshering.Carshering.repository;

import by.Carshering.Carshering.entity.Car;
import by.Carshering.Carshering.utils.dto.CarDto;
import by.Carshering.Carshering.utils.enumirations.Brend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findById(long id);
    void deleteById(long id);
    List<Car> findAll();
    List<Car> findByBrendLike(Brend brend);
    List<Car> findByModelLike(String model);

}
