package com.booking.service;


import com.booking.dto.BookingRequest;
import com.booking.dto.BookingResponse;
import com.booking.dto.Payment;
import com.booking.entity.Booking;
import com.booking.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RefreshScope
public class BookingService {

    @Autowired
    private BookingRepository bookingRespository;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String baseUrl;


    public BookingResponse bookOder(BookingRequest bookingRequest){
        Payment payment = new Payment();
        Booking bookOrder = bookingRequest.getBookOrder();
        payment.setAmount(bookOrder.getPrice());
        payment.setOrderId(bookOrder.getId());
        Payment paymentResponse = restTemplate.postForObject(baseUrl, payment, Payment.class);
        String response = paymentResponse.getPaymentStatus().equals("Success")?"Payment processed Successful":"Payment Failure";
        bookingRespository.save(bookOrder);
        return new BookingResponse(bookOrder,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
