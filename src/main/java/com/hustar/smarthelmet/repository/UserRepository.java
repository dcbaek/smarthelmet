package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
