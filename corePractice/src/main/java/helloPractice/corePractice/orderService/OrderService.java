package helloPractice.corePractice.orderService;

public interface OrderService {
    public int createOrder(Long memberId, String itemName, int itmePrice);
}
