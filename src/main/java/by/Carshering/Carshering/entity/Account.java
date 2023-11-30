package by.Carshering.Carshering.entity;

import by.Carshering.Carshering.utils.enumirations.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    @OneToMany
    private List<BoughtCar> boughtCars;
    @OneToOne
    private KreditCard kreditCard;
    private Role role;

}
