package helloPractice.corePractice.member;

import helloPractice.corePractice.memberRepository.MemoryMemberRepository;
import helloPractice.corePractice.memberService.Grade;
import helloPractice.corePractice.memberService.Member;
import helloPractice.corePractice.memberService.MemberService;
import helloPractice.corePractice.memberService.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        // given: MemoryMemberRepository를 생성하고 MemberServiceImpl에 주입
        // 이때 생성자 주입이 사용
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memoryMemberRepository);
    }

    @Test
    public void join() {
        // given
        Member member = new Member(1L, "daiseek", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
