package posECommerce.domain.entity.dto;

import lombok.Data;
import posECommerce.domain.enums.Role;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private Role role;
}
