package com.infobeans.loginservice.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobeans.loginservice.model.User;

/**
 * @author Tomesh
 *
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}