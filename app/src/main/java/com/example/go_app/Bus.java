package com.example.go_app;

public class Bus {

    private String ID;
    private String driverName;
    private String conductorName;
    private String vehicleNo;
    private String NoOfSeats;

    public Bus() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getConductorName() {
        return conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getNoOfSeats() {
        return NoOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        NoOfSeats = noOfSeats;
    }
}
