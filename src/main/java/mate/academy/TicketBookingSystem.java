package mate.academy;

import java.util.concurrent.Semaphore;

public class TicketBookingSystem {
    private Semaphore seats;

    public TicketBookingSystem(int totalSeats) {
        this.seats = new Semaphore(totalSeats, true);
    }

    public BookingResult attemptBooking(String user) {
        if (seats.tryAcquire()) {
            return new BookingResult(user, true, "Booking successful.");
        } else {
            return new BookingResult(user, false, "No seats available.");
        }
    }
}
