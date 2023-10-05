package waveofmymind.order.presentation;

import waveofmymind.order.application.RequestOrderCommand;
import waveofmymind.order.domain.OrderStatus;

public record OrderRequest(

        Long userId,

        long totalPrice,

        int quantity
) {
    public RequestOrderCommand toCommand() {
        return new RequestOrderCommand(userId, totalPrice, quantity, OrderStatus.ORDERED);
    }
}
