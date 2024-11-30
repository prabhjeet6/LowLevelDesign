package basics.concurrency.busywaitingandthreadsignaling;

public class Customer implements Runnable {
    private final int appointmentId;
    private final TickerBoard tickerBoard;

    public Customer(int appointmentId, TickerBoard tickerBoard) {
        this.appointmentId = appointmentId;
        this.tickerBoard = tickerBoard;
    }

    @Override
    public void run() {
        while (!this.tickerBoard.isMyTurn(this.appointmentId)) {
            System.out.println(this.appointmentId + " denied entry");
        }
        System.out.println(this.appointmentId + " allowed entry");
    }
}
