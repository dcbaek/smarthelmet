package com.hustar.smarthelmet.service;

import com.hustar.smarthelmet.domain.Manager;
import com.hustar.smarthelmet.repository.ManagerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepositoryy) {
        this.managerRepository = managerRepositoryy;
    }
    /**
     * 회원가입
     */
    public String join(Manager manager) {

        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(manager); //중복 회원 검증
            managerRepository.save(manager);
            return manager.getMid();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Manager manager) {
        managerRepository.findByMid(manager.getMid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Manager> findManagers() {

        long start = System.currentTimeMillis();

        try {
            return managerRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findManagers = " + timeMs + "ms");
        }
    }

//    public Optional<Manager> findOne(Long managerId) {
//        return managerRepository.findById(managerId);
//    }
}
