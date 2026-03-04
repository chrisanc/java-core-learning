package threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzMultithread {
    private int n;
    private int count = 1;
    // One semaphore for each thread (in order to manage their executions)
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);
    private final Semaphore number = new Semaphore(1);

    public FizzBuzzMultithread(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "semaphore".
    public void fizz(Runnable printFizz) throws InterruptedException {
        fizz.acquire();
        while (count <= n) {
            printFizz.run();
            this.count++;
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        buzz.acquire();
        while (count <= n) {
            printBuzz.run();
            this.count++;
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        fizzbuzz.acquire();
        while (count <= n) {
            printFizzBuzz.run();
            this.count++;
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    // Orchester - > Manages and decides when and which thread to wake up
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            number.acquire();
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                this.count++;
                number.release();
            } else {
                // Manage all the semaphores
                manageSemaphores();
            }
        }
        fizz.release();
        fizzbuzz.release();
        buzz.release();
    }

    public void manageSemaphores() {
        if (count % 15 == 0) {
            fizzbuzz.release(); // Wakes up the 'fizzbuzz' thread
        } else if (count % 5 == 0) {
            buzz.release(); // Wakes up the 'buzz' thread
        } else if (count % 3 == 0) {
            fizz.release(); // Wakes up the 'fizz' thread
        }
    }
}
