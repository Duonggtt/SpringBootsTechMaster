package com.example.springrelation;

import com.example.springrelation.entity.Customer;
import com.example.springrelation.entity.Order;
import com.example.springrelation.entity.User;
import com.example.springrelation.repository.CustomerRepository;
import com.example.springrelation.repository.OrderRepository;
import com.example.springrelation.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringrelationApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void save_customer() {
        for(int i =0; i< 2;i++) {
            Customer customer = Customer.builder()
                    .name("customer" + (i + 1))
                    .build();

            customerRepository.save(customer);

            for(int j =0;j<3;j++) {
                Order order = Order.builder()
                        .orderNumber(i+1)
                        .customer(customer)
                        .build();

                orderRepository.save(order);
            }
        }
    }

    @Test
    void delete_customer() {
        customerRepository.deleteById(1);
    }

    @Test
    void add_customer() {
        List<Order> orderList = new ArrayList<>();
        for(int j =0;j<3;j++) {
            Order order = Order.builder()
                    .orderNumber(j+1)
                    .build();
            orderList.add(order);
        }
        Customer customer = Customer.builder()
                .name("customer 3")
                .orders(orderList)
                .build();

        customerRepository.save(customer);
    }

    @Test
    void save_user() {
        for(int i=0;i<2;i++) {
            User user = User.builder()
                    .name("user" + (i+1))
                    .build();
            userRepository.save(user);
        }
    }
}
