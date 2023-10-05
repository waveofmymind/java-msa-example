package waveofmymind.order.application;

import waveofmymind.order.domain.Order;
import waveofmymind.order.domain.OrderStatus;

public record RequestOrderCommand(

        long userId,

        long totalPrice,

        int quantity,

        OrderStatus orderStatus
) {

    public Order toEntity() {
        return Order.builder()
                .userId(userId)
                .orderPrice(totalPrice)
                .orderQuantity(quantity).build();
    }
}
