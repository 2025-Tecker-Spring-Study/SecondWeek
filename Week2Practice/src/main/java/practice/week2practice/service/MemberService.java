package practice.week2practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.week2practice.domain.Member;
import practice.week2practice.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public void accountCreate(Member member){
        memberRepository.findByName(member.getName()).ifPresent(member1 ->
        {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        memberRepository.save(member);
    }

    // 회원 조회
   public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
   }
    // 전체 회원 조회
    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }
}
