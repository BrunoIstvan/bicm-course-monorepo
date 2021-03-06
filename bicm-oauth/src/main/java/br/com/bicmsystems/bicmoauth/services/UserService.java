package br.com.bicmsystems.bicmoauth.services;

import br.com.bicmsystems.bicmoauth.clients.UserFeignClient;
import br.com.bicmsystems.bicmoauth.entities.UserModel;
import br.com.bicmsystems.bicmoauth.exceptions.UserNotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public UserModel findByEmail(String email) throws UserNotFoundException {

        try {
            ResponseEntity<UserModel> response = userFeignClient.findByEmail(email);
            if(response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            throw new UserNotFoundException("User not found");
        } catch (FeignException ex) {
            throw new UserNotFoundException("User not found");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            ResponseEntity<UserModel> response = userFeignClient.findByEmail(email);
            if(response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            throw new UsernameNotFoundException("Email not found");
        } catch (FeignException ex) {
            throw new UsernameNotFoundException("Email not found");
        }

    }
}
