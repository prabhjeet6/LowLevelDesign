package basics.concurrency.busywaitingandthreadsignaling;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        List<Integer> appointments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            appointments.add(i);
        }
        TickerBoard tickerBoard = new TickerBoard(appointments);
        List<Customer> customers=new ArrayList<>();
        for (int i = 9; i >=0; i--) {
            Customer customer = new Customer(appointments.get(i), tickerBoard);
            customers.add(customer);
        }
        for(Customer customer:customers){
            Thread thread=new Thread(customer);
            thread.start();
        }
    }

}
