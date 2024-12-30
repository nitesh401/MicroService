package com.booking.dto;

import com.booking.entity.Booking;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Booking bookOrder;

    public Booking getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(Booking bookOrder) {
        this.bookOrder = bookOrder;
    }
}