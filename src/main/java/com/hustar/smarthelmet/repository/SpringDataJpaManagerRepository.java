package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaManagerRepository extends JpaRepository<Manager, Long>, ManagerRepository {

    @Override
    Optional<Manager> findByName(String name);

    @Override
    Optional<Manager> findByMid(String mid);

    @Override
    Optional<Manager> findByMale(String male);

    @Override
    Optional<Manager> findByPassword(String password);

    @Override
    Optional<Manager> findByBelong(String belong);
}
