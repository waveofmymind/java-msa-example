package waveofmymind.order.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waveofmymind.order.application.OrderService;
import waveofmymind.order.domain.Order;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("/orders")
    public String requestOrder(@RequestBody
                               OrderRequest request) {
        orderService.requestOrder(request.toCommand());

        return "Order requested";
    }
}
