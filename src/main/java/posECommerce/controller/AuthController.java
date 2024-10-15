package posECommerce.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import posECommerce.domain.entity.request.User;
import posECommerce.repository.IUserRepository;
import posECommerce.security.JwtUtil;
import posECommerce.domain.entity.dto.AuthenticationRequest;
import posECommerce.domain.entity.dto.SignupRequest;
import posECommerce.domain.entity.dto.UserDto;
import posECommerce.security.UserDetailServiceImpl;
import posECommerce.service.auth.IAuthService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IAuthService authService;

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";

    //LOGIN
    @PostMapping("/authentication")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest request, HttpServletResponse response) throws IOException, JSONException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch (BadCredentialsException e){
            throw  new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
        Optional<User> optionalUser =  IUserRepository.findFirstByEmail(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        if (optionalUser.isPresent()) {
            response.getWriter().write(new JSONObject()
                    .put("userId", optionalUser.get().getId())
                    .put("role", optionalUser.get().getRole())
                    .toString()
            );

            response.addHeader("Access-Control-Expose-Headers", "Authorization");
            response.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, " +
                    "X-Requested-With, Content-Type, Accept, X-Custom-header");

            response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);

        }
    }

    //REGISTER
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody SignupRequest signupRequest){
        if (authService.hasUserWithEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto userDto = authService.createUser(signupRequest);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
