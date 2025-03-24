package helloPractice.corePractice.memberService;

public interface MemberService {
    // 회원조회, 회원가입 메서드
    void join(Member member);

    public Member findMember(Long memberId);

}
