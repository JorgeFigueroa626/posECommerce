package posECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posECommerce.domain.entity.request.User;
import posECommerce.domain.enums.Role;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    User findByRole(Role role);
}
