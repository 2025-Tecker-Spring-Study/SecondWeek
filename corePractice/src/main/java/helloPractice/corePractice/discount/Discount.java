package helloPractice.corePractice.discount;
import helloPractice.corePractice.memberService.Grade;
import helloPractice.corePractice.memberService.Member;

public interface Discount {
    public int discount(Member member, Grade grade);
}
