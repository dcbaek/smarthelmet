package com.hustar.smarthelmet.repository;

import com.hustar.smarthelmet.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> deleteById(Long id);
    List<Member> findAll();
}
