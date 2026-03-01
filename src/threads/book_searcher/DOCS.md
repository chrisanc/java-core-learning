## **Book searcher program (Introduction to Threads)**
This program was made to search in N books a certain word using threads to
improve the performance and speed of the script.

I used a FixedThreadPool because I know how many threads I'll need, but there's
many pools you could use, as they're basically the same but with some small
differences.
```java
String[] names = new String[]{"test.txt", "lib1.txt", "lib2.txt", "lib3.txt"};
ExecutorService service = Executors.newFixedThreadPool(names.length);
```
This allowed me to specify the amount of threads I'll use, in this case is one
per file.

*Notice the 'names' could be automatized by reading all the names from the directory*

Notice that I used the 'synchronized' keyword
```java
public static synchronized void increaseCount(AtomicInteger value) {
    value.set(value.get() + 1);
}
```
This keyword allows you to have control on the race condition between threads,
ensuring no more than 2 threads will be modifying the variable at the same time.

*By Christian David Sánchez Sánchez*

*February 28th, 2026*