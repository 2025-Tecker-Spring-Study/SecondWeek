package helloPractice.corePractice.order;

import helloPractice.corePractice.discount.FixDiscount;
import helloPractice.corePractice.memberRepository.MemoryMemberRepository;
import helloPractice.corePractice.memberService.Grade;
import helloPractice.corePractice.memberService.Member;
import helloPractice.corePractice.orderService.OrderService;
import helloPractice.corePractice.orderService.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    // 주입받을 객체의 인터페이스 선언
    private OrderService orderService;
    private MemoryMemberRepository memberRepository; // 🔹 MemoryMemberRepository 추가

    // 테스트 전 실행됨
    // 주입되는 객체를 새롭게 세팅하는 메서드
    @BeforeEach
    public void setUp() {
        memberRepository = new MemoryMemberRepository();
        FixDiscount fixDiscount = new FixDiscount();

        orderService = new OrderServiceImpl(memberRepository, fixDiscount);
    }

    @Test
    public void createOrder()

    {
        // given
        Member member = new Member(2L, "dai", Grade.VIP);
        memberRepository.save(member);
        int itemPrice = 10000;
        String itemName = "MiniCar";


        // when
        int finalPrice = orderService.createOrder(member.getmemberId(), itemName, itemPrice);


        // then
        Assertions.assertThat(finalPrice).isEqualTo(9000);

    }


}
