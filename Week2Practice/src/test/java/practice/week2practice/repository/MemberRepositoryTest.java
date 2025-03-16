package practice.week2practice.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.week2practice.domain.Member;

import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    void afterEach(){
        memberRepository.deleteAll();
    }
    @Test
    void save() {
        Member member1 = new Member();
        member1.setName("spring");
        memberRepository.save(member1);
    }

    @Test
    void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();
        Assertions.assertEquals(members.size(), 2);
    }
    @Test
    void findById(){

    }
    @Test
    void findByName(){

    }

}