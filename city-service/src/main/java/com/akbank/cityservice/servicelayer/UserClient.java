package com.akbank.cityservice.servicelayer;

import com.akbank.cityservice.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping(value = "/api/users/{username}")
    Optional<City> getUsername(@PathVariable String username);

}
