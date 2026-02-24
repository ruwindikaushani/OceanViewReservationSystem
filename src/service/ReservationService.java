package service;

import java.util.ArrayList;
import java.util.List;
import model.Reservation;

public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    // ✅ THIS METHOD MUST EXIST (same name, same parameter)
    public Reservation findReservation(String reservationNo) {
        for (Reservation r : reservations) {
            if (r.getReservationNo().equalsIgnoreCase(reservationNo)) {
                return r;
            }
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
