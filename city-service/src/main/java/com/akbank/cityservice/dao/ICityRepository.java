package com.akbank.cityservice.dao;

import com.akbank.cityservice.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {
    List<City> findCitiesByUsername(String username);

    Optional<City> findCityByCityName(String cityName);

}
