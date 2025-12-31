package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;
import com.service.OrderService;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/buy")
	@Timed(value="order.placed.time")
	@Counted(value="order.placed.count")
	public OrderResponseDto placeOrder(@RequestBody List<OrderRequestDto> orderRequestDto) {
		OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
		return orderResponseDto;
	}

	@GetMapping("/{orderId}") /// Get Order By ID
	@Timed(value="order.get.time")
	@Counted(value="order.get.count")
	public ResponseEntity<OrderResponseDto> getOrder(@PathVariable(name = "orderId") long orderId) {
		ResponseEntity<OrderResponseDto> orderResponseDto = orderService.getOrderInfo(orderId);
		return orderResponseDto;
	}

	@DeleteMapping("/{orderId}") /// Delete Specific Order
	public String deleteOrderId(@PathVariable(name = "orderId") long orderId) {
		String orderResponseDto = orderService.deleteOrder(orderId);
		return orderResponseDto;
	}

	@DeleteMapping("/cancel/{orderItemId}") /// Delete Specific Order Item
	public ResponseEntity<Void> cancelOrderItemId(@PathVariable(name = "orderItemId") long orderItemId) {
		ResponseEntity<Void> orderResponseDto = orderService.deleteOrderItem(orderItemId);
		return orderResponseDto;
	}

}
