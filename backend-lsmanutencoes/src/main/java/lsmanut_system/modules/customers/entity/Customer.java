package lsmanut_system.modules.customers.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer customer_code;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Email(message = "O campo [email], deve conter um e-mail válido!")
    @Column
    private String email;

    @Length(min = 11, max = 22)
    @Column(unique = true, nullable = false)
    private String cpf;

    @Column
    private Integer fc_addresscode;

    @Column
    private Integer fc_citycode;

    @Column
    private Integer fc_professioncode;
}
