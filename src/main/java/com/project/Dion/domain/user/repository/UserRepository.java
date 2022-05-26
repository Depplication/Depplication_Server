package com.project.Dion.domain.user.repository;

import com.project.Dion.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
