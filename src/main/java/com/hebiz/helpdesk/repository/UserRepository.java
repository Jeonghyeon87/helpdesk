package com.hebiz.helpdesk.repository;

import com.hebiz.helpdesk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // User findByUserId(String userId);
}
