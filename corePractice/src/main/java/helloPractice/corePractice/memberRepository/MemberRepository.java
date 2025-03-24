package helloPractice.corePractice.memberRepository;

import helloPractice.corePractice.memberService.Member;

public interface MemberRepository {
    // Q. 회원 조회 메서드가 2개인 이유가 머임

    void save(Member member);

    public Member findById(Long memberId);


}
