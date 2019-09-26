package ru.votingsystem.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.votingsystem.service.interfaces.UserService;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserService service;

    public UserPrincipalDetailsService(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AuthorizedUser(service.getByEmail(email));
    }
}
