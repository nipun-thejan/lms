package com.thejan.lms.repository;

import com.thejan.lms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AdminRepository extends UserBaseRepository<Admin> {
}
