package com.example.go_app;

import java.util.ArrayList;

public class UserTicket {

    private String UserId;
    private String UserEmail;
//    ArrayList<Integer> SeatList;
    private String SeatList;
    private String Price;

    public UserTicket() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getSeatList() {
        return SeatList;
    }

    public void setSeatList(String seatList) {
        this.SeatList = seatList;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
