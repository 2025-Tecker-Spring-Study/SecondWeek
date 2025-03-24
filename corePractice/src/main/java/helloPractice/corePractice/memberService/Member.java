package helloPractice.corePractice.memberService;

public class Member {
    // 필드, 생성자, 메소드 정의
    private Long memberId;
    private String name;
    private Grade grade;


    // 생성자
    public Member(Long memberId, String name, Grade grade) {
        this.memberId = memberId;
        this.name = name;
        this.grade = grade;
    }

    // 메서드
    // 1. 회원 아이디, 이름, 그레이드 가져오는 메소드
    public String getName() {
        return name;
    }

    public Long getmemberId() {
        return memberId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }





}
