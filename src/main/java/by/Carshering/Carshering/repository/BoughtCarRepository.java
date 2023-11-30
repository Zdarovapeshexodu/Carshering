package by.Carshering.Carshering.repository;

import by.Carshering.Carshering.entity.BoughtCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtCarRepository extends JpaRepository<BoughtCar,Long> {
    BoughtCar findById(long id);
    void deleteById(long id);
}
