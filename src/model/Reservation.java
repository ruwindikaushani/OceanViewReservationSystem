package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private String reservationNo;
    private String guestName;
    private String address;
    private String contactNo;
    private String roomType;

    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(String reservationNo, String guestName, String address,
                       String contactNo, String roomType,
                       LocalDate checkIn, LocalDate checkOut) {
        this.reservationNo = reservationNo;
        this.guestName = guestName;
        this.address = address;
        this.contactNo = contactNo;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getReservationNo() { return reservationNo; }
    public String getGuestName() { return guestName; }
    public String getAddress() { return address; }
    public String getContactNo() { return contactNo; }
    public String getRoomType() { return roomType; }

    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }

    // ✅ Nights calculated automatically
    public long getNights() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }
}
