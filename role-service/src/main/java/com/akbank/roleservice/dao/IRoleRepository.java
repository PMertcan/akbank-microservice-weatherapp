package com.akbank.roleservice.dao;

import com.akbank.roleservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByUsername(String username);

}
