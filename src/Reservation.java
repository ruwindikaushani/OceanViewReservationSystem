public class Reservation {
    private String reservationNo;
    private String guestName;
    private String address;
    private String contactNo;
    private String roomType;
    private int nights;

    public Reservation(String reservationNo, String guestName, String address,
                       String contactNo, String roomType, int nights) {
        this.reservationNo = reservationNo;
        this.guestName = guestName;
        this.address = address;
        this.contactNo = contactNo;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getReservationNo() { return reservationNo; }
    public String getGuestName() { return guestName; }
    public String getAddress() { return address; }
    public String getContactNo() { return contactNo; }
    public String getRoomType() { return roomType; }
    public int getNights() { return nights; }
}
             
    

