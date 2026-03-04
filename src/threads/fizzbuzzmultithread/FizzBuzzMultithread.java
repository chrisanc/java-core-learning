package threads.fizzbuzzmultithread;

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
        // Set the semaphore at negative values
        fizz.acquire();
        while (count <= n) {
            printFizz.run();
            this.count++;
            number.release();
            fizz.acquire();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        // Set the semaphore at -1 at first
        buzz.acquire();
        while (count <= n) {
            printBuzz.run();
            this.count++;
            number.release();
            buzz.acquire();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // Set the semaphore at -1 at first
        fizzbuzz.acquire();
        while (count <= n) {
            printFizzBuzz.run();
            this.count++;
            // Number semaphore from -1 -> 0
            number.release();
            fizzbuzz.acquire();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    // Orchester - > Manages and decides when and which thread to wake up
    public void number(IntConsumer printNumber) throws InterruptedException {
        // While the count value is <= the N, we loop
        while (count <= n) {
            // Acquire a permit from the semaphore: 1 -> 0 (not blocking yet)
            number.acquire();
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                this.count++;
            } else {
                // Manage all the semaphores
                manageSemaphores();
                // Block the execution: 0 -> -1 BLOCK
                number.acquire();
                // Any function there will release the semaphore after
                // it's execution: -1 -> 0
            }
            // From 0 -> 1 in the semaphore, activating it again
            number.release();
        }
        // Release all the semaphores so they can finish their execution
        fizz.release();
        fizzbuzz.release();
        buzz.release();
    }

    public void manageSemaphores() throws InterruptedException {
        if (count % 15 == 0) {
            fizzbuzz.release(); // Wakes up the 'fizzbuzz' thread
        } else if (count % 5 == 0) {
            buzz.release(); // Wakes up the 'buzz' thread
        } else if (count % 3 == 0) {
            fizz.release(); // Wakes up the 'fizz' thread
        }
    }
}
