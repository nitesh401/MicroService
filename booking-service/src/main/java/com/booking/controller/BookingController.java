package com.booking.controller;

import com.booking.dto.BookingRequest;
import com.booking.dto.BookingResponse;
import com.booking.entity.Booking;
import com.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping("/bookOrder")
    public BookingResponse bookOrder(@RequestBody BookingRequest bookingRequest){
        return bookingService.bookOder(bookingRequest);
    }
}
