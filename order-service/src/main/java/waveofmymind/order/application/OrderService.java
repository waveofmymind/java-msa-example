package waveofmymind.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import waveofmymind.order.domain.Order;
import waveofmymind.order.domain.OrderRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("Order not found")
        );
    }

    public void requestOrder(RequestOrderCommand command) {
        Order order = command.toEntity();
        orderRepository.save(order);
    }
}
