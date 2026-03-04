package threads.fizzbuzzmultithread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        FizzBuzzMultithread fb = new FizzBuzzMultithread(n);

        Thread fizz = new Thread(() -> {
            try {
                fb.fizz(() -> System.out.println("Fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread buzz = new Thread(() -> {
            try {
                fb.buzz(() -> System.out.println("Buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread fizzbuzz = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.println("FizzBuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread number = new Thread(() -> {
            try {
                fb.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        number.start();
        fizz.start();
        buzz.start();
        fizzbuzz.start();

        number.join();
        fizz.join();
        buzz.join();
        fizzbuzz.join();
    }
}
