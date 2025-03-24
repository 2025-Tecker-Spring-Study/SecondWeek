package helloPractice.corePractice.discount;
import helloPractice.corePractice.memberService.Grade;
import helloPractice.corePractice.memberService.Member;

public class FixDiscount implements Discount {

    int discountPrice = 1000;

    @Override
    public int discount(Member member, Grade grade) {
        if (grade == Grade.VIP) {
            return discountPrice;
        }
        else {
            return 0;
        }
    }


}
