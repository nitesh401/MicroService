package com.booking.dto;

import com.booking.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Booking bookOrder;
    private Double amount;
    private String transactionId;
    private String response;

    public Booking getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(Booking bookOrder) {
        this.bookOrder = bookOrder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}