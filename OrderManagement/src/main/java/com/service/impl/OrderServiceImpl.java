package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.OrderItemRepository;
import com.dao.OrderRepository;
import com.dao.ProductRepository;
import com.dto.OrderItemResponseDto;
import com.dto.OrderRequestDto;
import com.dto.OrderResponseDto;
import com.exceptions.OrderItemNotFoundException;
import com.exceptions.OrderNotFoundException;
import com.model.Order;
import com.model.OrderItem;
import com.model.Product;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger LOG=LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	

	@Override
	public OrderResponseDto placeOrder(List<OrderRequestDto> orderRequestDto) {
		LOG.trace("Received orderRequest:{}", orderRequestDto);//tracc logging
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		order.setStatus("Ordered");

		for (OrderRequestDto orderRequest : orderRequestDto) {
			LOG.debug("OrderRequest List");
			OrderItem orderItem = new OrderItem();
			Product product = productRepository.findById(orderRequest.getProductId())
					.orElseThrow(() -> {
					    LOG.error("Cannot find the Product id with id: {}", orderRequest.getProductId());
					    return new RuntimeException("Id not found");    //error log
					});
			if (product.getStock() >= orderRequest.getQuantity()) {
				orderItem.setQuantity(orderRequest.getQuantity());
				orderItem.setProduct(product);
				orderItem.setOrder(order);
				orderItems.add(orderItem);
				LOG.info("List of orderItem{}",orderItems);   //info log
				productRepository.updateStock(orderRequest.getProductId(),
						product.getStock() - orderRequest.getQuantity());
			}
			else
				LOG.warn("Insufficient stock only {} avialable",product.getStock());   ///warn logger
		}
		order.setOrderItems(orderItems);
		Order savedOrder = orderRepository.save(order);

		return buildResponseDto(savedOrder);
	}

	@Override 
	public ResponseEntity<OrderResponseDto> getOrderInfo(long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with Id:" + orderId));
		OrderResponseDto orderResponse=buildResponseDto(order);
		return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
	}
	
	@Override
	public String deleteOrder(long orderId) {
		Order deleteOrder=orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with Id:" + orderId));
		
		orderRepository.delete(deleteOrder);
		return "The given Order ID is deleted Successfully" ;
	}
	
	@Override
	public ResponseEntity<Void> deleteOrderItem(long orderItemId) {
		OrderItem orderItem=orderItemRepository.findById(orderItemId).orElseThrow(()-> new OrderItemNotFoundException("Order Item is not found with id:"+orderItemId));
		
		orderItemRepository.delete(orderItem);
		
		long productId=orderItem.getProduct().getProductId();
		int stock=orderItem.getProduct().getStock();
		productRepository.updateStock(productId, stock+orderItem.getQuantity());
		return ResponseEntity.noContent().build();
	}


	public OrderResponseDto buildResponseDto(Order savedOrder) {
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		orderResponseDto.setOrderId(savedOrder.getOrderId());
		orderResponseDto.setStatus(savedOrder.getStatus());
		List<OrderItemResponseDto> orderItemResponseDtoList = new ArrayList<OrderItemResponseDto>();
		double totalOrderAmount = 0;
		for (OrderItem orderItem : savedOrder.getOrderItems()) {
			OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
			orderItemResponseDto.setProductId(orderItem.getProduct().getProductId());
			orderItemResponseDto.setProductName(orderItem.getProduct().getProductName());
			orderItemResponseDto.setQuantity(orderItem.getQuantity());
			double eachProductPrice = orderItem.getProduct().getPrice()
					* ((100 - orderItem.getProduct().getDiscount()) / 100);
			orderItemResponseDto.setEachProductPrice(eachProductPrice);
			double totalPrice = eachProductPrice * orderItem.getQuantity();
			orderItemResponseDto.setTotalProductPrice(totalPrice);
			totalOrderAmount += totalPrice;
			orderItemResponseDtoList.add(orderItemResponseDto);

		}
		orderResponseDto.setTotalAmount(totalOrderAmount);
		orderResponseDto.setOrderItemResponseDto(orderItemResponseDtoList);

		return orderResponseDto;
	}

	
	

}
