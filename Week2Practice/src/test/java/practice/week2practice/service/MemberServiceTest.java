package practice.week2practice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.week2practice.domain.Member;
import practice.week2practice.repository.MemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @AfterEach
    void afterEach(){
        memberRepository.deleteAll();
    }
    @Test
    void 회원가입() throws Exception {
        Member member1 = new Member();
        member1.setName("woomin1");
        memberService.accountCreate(member1);
        Optional<Member> member = memberRepository.findByName("woomin1");
        assertEquals("woomin1", member.get().getName());
    }

}