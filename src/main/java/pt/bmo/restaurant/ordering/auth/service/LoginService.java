package pt.bmo.restaurant.ordering.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import pt.bmo.restaurant.ordering.auth.enums.UserRole;
import pt.bmo.restaurant.ordering.auth.model.LoginRequest;
import pt.bmo.restaurant.ordering.auth.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    public User generateUserToken(LoginRequest loginRequest) {

        User user = new User();
        user.setId(loginRequest.getUserId());
        user.setName("Test");
        user.setRole(UserRole.WAITER);

        String secretKey = "mySecretKey";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("bmoJWT")
                .setSubject(user.getId().toString().concat("#").concat(user.getName()))
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        user.setToken("Bearer " + token);
        return user;
    }
}
