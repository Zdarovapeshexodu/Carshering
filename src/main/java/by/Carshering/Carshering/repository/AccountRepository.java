package by.Carshering.Carshering.repository;

import by.Carshering.Carshering.entity.Account;
import by.Carshering.Carshering.entity.BoughtCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByLogin(String login);
    Account findById(long id);

}
