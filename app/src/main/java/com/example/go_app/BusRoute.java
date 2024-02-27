package com.example.go_app;


public class BusRoute {

    private int RefID;
    private String StartTime;
    private String StartLocation;
    private String EndTime;
    private String EndLocation;
    private String BusNumber;
    private String DriverName;
    private String Currency;
    private String Date;
    private Float Price;
    private int NoSeats;
    private int NoPassengers;

//    private Date created;
//    private Date updated;
//    private String objectID;


    public int getRefID() {
        return RefID;
    }

    public void setRefID(int refID) {
        RefID = refID;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(String endLocation) {
        EndLocation = endLocation;
    }

    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String busNumber) {
        BusNumber = busNumber;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public int getNoSeats() {
        return NoSeats;
    }

    public void setNoSeats(int noSeats) {
        NoSeats = noSeats;
    }

    public int getNoPassengers() {
        return NoPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        NoPassengers = noPassengers;
    }
}
