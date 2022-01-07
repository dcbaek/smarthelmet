package com.hustar.smarthelmet;

import com.hustar.smarthelmet.repository.MemberRepository;
import com.hustar.smarthelmet.repository.MemoryMemberRepository;
import com.hustar.smarthelmet.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
