package posECommerce.domain.entity.request;

import jakarta.persistence.*;
import lombok.Data;
import posECommerce.domain.enums.Role;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private Role role;

    @Lob
    @Column(columnDefinition = "longblob")
    private  byte[] img;

}
