package basics.concurrency.busywaitingandthreadsignaling;

public class Customer implements Runnable {

    private final Integer appointmentId;
    private final TickerBoard TickerBoard;//monitor to get the lock upon

    public Customer(Integer appointmentId, TickerBoard TickerBoard) {
        this.appointmentId = appointmentId;
        this.TickerBoard = TickerBoard;
    }


    @Override
    public void run() {
        synchronized (TickerBoard) {
            while (!TickerBoard.isMyTurn(appointmentId)) {
                try {
                    System.out.println("Entry denied: " + appointmentId);
                    TickerBoard.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hi I am appointment id: " + appointmentId);
            TickerBoard.notifyAll();
        }
    }
}