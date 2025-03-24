package helloPractice.corePractice.orderService;
import helloPractice.corePractice.discount.FixDiscount;
import helloPractice.corePractice.memberRepository.MemberRepository;
import helloPractice.corePractice.memberService.Member;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final FixDiscount fixDiscount;

    // 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, FixDiscount fixDiscount) {
        this.memberRepository = memberRepository;
        this.fixDiscount = fixDiscount;
    }


    @Override
    public int createOrder(Long memberId, String itmeName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보 조회
        int discount = fixDiscount.discount(member, member.getGrade());
        return itemPrice - discount;
    }
}
