package basics.concurrency.busywaitingandthreadsignaling;

import java.util.List;

public class TickerBoard {
    public int current;
    private final List<Integer> appointments;

    public TickerBoard(List<Integer> appointments) {
        this.current = 0;
        this.appointments = appointments;
    }

    public synchronized boolean isMyTurn(int appointmentId) {
        if (this.current == appointments.size()) {
            throw new RuntimeException("No more appointments");
        }
        if (this.current != appointmentId) {
            return false;
        }
        this.current++;
        return true;
    }
}
