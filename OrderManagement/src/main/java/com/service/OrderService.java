package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;

public interface OrderService {
	
	public OrderResponseDto placeOrder(List<OrderRequestDto> orderRequestDto);

	public ResponseEntity<OrderResponseDto> getOrderInfo(long orderId);

	public String deleteOrder(long orderId);

	public ResponseEntity<Void> deleteOrderItem(long orderItemId);

}
