package com.polarbookshop.orderservice.order.web;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.polarbookshop.orderservice.order.domain.OrderService;

@WebMvcTest(OrderController.class)
public class BookTest {

	@Mock
	private OrderService orderService;

	@Test
	public void testBook() {
     System.out.println("hello");
	}

	@Test
	public void testBook2() {

	}

	@Test
	public void testBook3() {

	}

	@Test
	public void testBook4() {

	}

	@Test
	public void testBook5() {

	}

	@Test
	public void testBook6() {

	}

	@Test
	public void testBook7() {

	}

	@Test
	public void testBook8() {

	}

}