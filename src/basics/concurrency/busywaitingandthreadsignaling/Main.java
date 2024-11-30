package signaling.example2;

import basics.concurrency.busywaitingandthreadsignaling.Customer;
import basics.concurrency.busywaitingandthreadsignaling.TickerBoard;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Integer> appointments = new ArrayList<>();

        for (int i = 0; i < 10; i++) appointments.add(i);

        TickerBoard tickingBoard = new TickerBoard(appointments);

        for (int i = 9; i >= 0; i--) {
            customers.add(new Customer(appointments.get(i), tickingBoard));
        }

        for (int i = 0; i < 10; i++) new Thread(customers.get(i)).start();

    }
}