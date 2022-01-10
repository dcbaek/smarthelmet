package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.domain.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository {
    Manager save(Manager manager);
    Optional<Manager> findByMid(String mid);
    Optional<Manager> findByName(String name);
    Optional<Manager> findByMale(String male);
    Optional<Manager> findByPassword(String password);
    Optional<Manager> findByBelong(String belong);
    List<Manager> findAll();
}
