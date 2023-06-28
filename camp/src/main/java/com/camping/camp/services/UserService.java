package com.camping.camp.services;

import com.camping.camp.Exception.UserAlreadyExistAuthenticationException;
import com.camping.camp.dto.LocalUser;
import com.camping.camp.dto.SignUpRequest;
import com.camping.camp.entities.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

    User findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
