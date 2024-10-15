package posECommerce.service.auth;

import posECommerce.domain.entity.dto.SignupRequest;
import posECommerce.domain.entity.dto.UserDto;

public interface IAuthService {

    public UserDto createUser(SignupRequest signupRequest);

    public Boolean hasUserWithEmail(String email);

    public void createAdminAccount();
}
