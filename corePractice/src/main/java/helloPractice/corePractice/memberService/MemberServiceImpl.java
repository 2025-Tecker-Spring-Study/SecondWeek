package helloPractice.corePractice.memberService;

import helloPractice.corePractice.memberRepository.MemberRepository;
import helloPractice.corePractice.memberRepository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

    // 필드로서 메모리멤버레포지토리를 주입받음
    MemberRepository memberRepository = new MemoryMemberRepository();
    


    // 생성자 추가: MemoryMemberRepository를 매개변수로 받는 생성자 -> 테스트에서 사용하기 위함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
