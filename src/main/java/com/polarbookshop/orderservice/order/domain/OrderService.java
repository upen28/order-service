package com.polarbookshop.orderservice.order.domain;

import org.springframework.stereotype.Service;

import com.polarbookshop.orderservice.book.Book;
import com.polarbookshop.orderservice.book.BookClient;
import com.polarbookshop.orderservice.order.web.OrderRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private final BookClient bookClient;

	public OrderService(OrderRepository repoitory, BookClient bookClient) {
		this.orderRepository = repoitory;
		this.bookClient = bookClient;
	}

	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Mono<Order> submitOrder(OrderRequest orderRequest) {
		return bookClient.getBookByIsbn(orderRequest.isbn())
				.map(book -> buildAcceptedOrder(book, orderRequest.quantity()))
				.defaultIfEmpty(buildRejectedOrder(orderRequest.isbn(), orderRequest.quantity()))
				.flatMap(orderRepository::save);
	}

	public static Order buildAcceptedOrder(Book book, int quantity) {
		return Order.of(book.isbn(), book.title() + " - " + book.author(), book.price(), quantity,
				OrderStatus.ACCEPTED);
	}

	public static Order buildRejectedOrder(String bookIsbn, int quantity) {
		return Order.of(bookIsbn, null, null, quantity, OrderStatus.REJECTED);
	}

}
