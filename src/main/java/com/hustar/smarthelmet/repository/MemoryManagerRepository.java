package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.domain.Manager;

import java.util.*;

public class MemoryManagerRepository implements ManagerRepository {

    private static Map<String, Manager> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Manager save(Manager manager) {
//        manager.setMid(++sequence);
        store.put(manager.getMid(), manager);
        return manager;
    }
    @Override
    public Optional<Manager> findByMid(String id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Manager> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Manager> findByName(String name) {
        return store.values().stream()
                .filter(manager -> manager.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Manager> findByMale(String male) {
        return Optional.ofNullable(store.get(male));
    }

    @Override
    public Optional<Manager> findByPassword(String password) {
        return Optional.ofNullable(store.get(password));
    }

    @Override
    public Optional<Manager> findByBelong(String belong) {
        return Optional.ofNullable(store.get(belong));
    }

    public void clearStore() {
        store.clear();
    }
}
