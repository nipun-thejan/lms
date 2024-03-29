package com.thejan.lms.repository;


import com.thejan.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findUserByEmail(String email);
	// boolean existsByUsername(String username);
}