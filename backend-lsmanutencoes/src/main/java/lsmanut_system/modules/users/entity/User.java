package lsmanut_system.modules.users.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço!")
    @Column(nullable = false, unique = true)
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido!")
    @Column(nullable = false, unique = true)
    private String email;

    @Length(min = 10, max = 20, message = "A senha deve conter entre 10 e 20 caracteres!")
    @Column(nullable = false)
    private String password;
}
