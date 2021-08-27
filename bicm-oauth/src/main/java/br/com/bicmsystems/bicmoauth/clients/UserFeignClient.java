package br.com.bicmsystems.bicmoauth.clients;

import br.com.bicmsystems.bicmoauth.entities.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "bicm-user", path = "users")
public interface UserFeignClient {

    @GetMapping("/search")
    ResponseEntity<UserModel> findByEmail(@RequestParam String email);

}


