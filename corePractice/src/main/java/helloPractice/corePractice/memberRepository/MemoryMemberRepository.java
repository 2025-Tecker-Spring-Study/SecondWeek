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
        // stream 메서드를 통해 List로 받은 데이터를 Steam으로 변환
        // Stream : 데이터 소스를 다루는 추상적 방법
        return members.stream() 
                
                // filter의 조건에 맞는 요소만 추출
                // member의 memberId가 매개변수로 받은 memberId와 같은지 확인
                .filter(member -> member.getmemberId().equals(memberId))
                
                // Stream에서 첫 번째로 조건을 만족하는 요소 반환
                // 반환 값은 Optional<T> 객체
                // 값이 없을수도 있기 때문에 Optional로 반환
                .findFirst()
                
                // Optional 객체의 값이 없다면 디폴트로 null 반환
                .orElse(null);
    }
}


// 실습에서는 Map 객체를 이용하여 회원 객체 데이터를 받았는데, 여기서는 List를 사용
// List는 순서가 있고, 중복이 허용됨
// Map은 순서가 보장되지 않지만, 중복이 허용되지 않음.
// 따라서 회원 데이터를 저장할 때는 Map이 더 적절함


