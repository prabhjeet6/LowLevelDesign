package basics.concurrency.fizzbuzz;

public class FizzBuzzSimulator {

    public static int curr = 1;
    public static int total = 15;

    //print numbers in sequence, but ,also, print the numbers from a particular thread
    //Use thread signaling(wait notify) instead of busy
    // locking/spin lock(looping until thread comes to execution)
    public static void main(String[] args) {

        Object lock = new Object();
        Thread fizz = new Thread(new Fizz("fizz", lock));
        Thread buzz = new Thread(new Buzz("buzz", lock));
        Thread fizzbuzz = new Thread(new FizzBuzz("fizzbuzz", lock));
        Thread plain = new Thread(new Plain("plain", lock));

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        plain.start();
    }
}