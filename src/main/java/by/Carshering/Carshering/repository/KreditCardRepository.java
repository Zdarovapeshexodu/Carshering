package by.Carshering.Carshering.repository;

import by.Carshering.Carshering.entity.KreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KreditCardRepository extends JpaRepository<KreditCard,Long> {
    KreditCard findByCardNumber(String cardNumber);
}
