package helloPractice.corePractice.memberRepository;

import helloPractice.corePractice.memberService.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        // Member 클래스에 멤버가 저장되어 있어야 add 메소드를 사용 가능
        members.add(member);

    }

    @Override
    public Member findById(Long memberId) {
        return members.stream()
                .filter(member -> member.getmemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
}
