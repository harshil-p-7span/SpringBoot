package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Used to mark a class as a repository, typically for database access.
public interface UserRepository extends JpaRepository<User, Long> {
}
