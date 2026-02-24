package service;

import model.Reservation;

public class BillingService {

    public double getRoomRate(String roomType) {
        switch (roomType.toLowerCase()) {
            case "single":
                return 5000;
            case "double":
                return 8000;
            case "deluxe":
                return 12000;
            default:
                return 0;
        }
    }

    public double calculateTotal(Reservation r) {
        double rate = getRoomRate(r.getRoomType());
        return rate * r.getNights(); // ✅ auto nights
    }
}
