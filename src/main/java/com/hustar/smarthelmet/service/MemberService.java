package com.hustar.smarthelmet.service;

import com.hustar.smarthelmet.domain.Member;
import com.hustar.smarthelmet.repository.MemberRepository;
import com.hustar.smarthelmet.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        long start = System.currentTimeMillis();

        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = " + timeMs + "ms");
        }
    }

//    public Optional<Member> delete(Long id, Member member) {
//
//        Member member = memberRepository.findById(id).orElseThrow()->
//            new IllegalArgumentException("해당 아이디가 없습니다."+id);
//        memberRepository.delete(member);
//        return
//    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

//    public void deletePost(Long id) {
//        Optional<Member> member = memberRepository.findById(id);
//        if (member.isPresent()) {
//            memberRepository.deleteById(member.get().getId());
//        }
//
//    }
}
