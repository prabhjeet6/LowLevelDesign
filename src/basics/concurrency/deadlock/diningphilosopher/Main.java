package basics.concurrency.deadlock.diningphilosopher;

import basics.concurrency.deadlock.diningphilosopher.Chopstick;

 class DiningPhilosopherSimulator {

    public static void main(String[] args) {

        Chopstick c1 = new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3 = new Chopstick(3);
        Chopstick c4 = new Chopstick(4);
        Chopstick c5 = new Chopstick(5);

        Thread p1 = new Thread(new Philosopher(c1, c2, "Pythogoras"));
        Thread p2 = new Thread(new Philosopher(c2, c3, "Aristotle"));
        Thread p3 = new Thread(new Philosopher(c3, c4, "Socrates"));
        Thread p4 = new Thread(new Philosopher(c4, c5, "Plato"));
        Thread p5 = new Thread(new Philosopher(c5, c1, "Aurobindo"));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}