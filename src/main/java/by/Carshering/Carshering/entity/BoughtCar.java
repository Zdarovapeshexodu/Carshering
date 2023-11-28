package by.Carshering.Carshering.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class BoughtCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Car car;
    private int primeTime;
}
