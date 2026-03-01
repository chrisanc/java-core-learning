## **Book Searcher Program (Introduction to Threads)**
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

**How can I manage the termination of the all the threads created?**
```java
service.shutdown();
```
This blocks the service, blocking new threads to be executed and allowing the
existing threads to finish.

If we execute any code just after this, it won't wait the threads to finish their
execution, so if you're gonna need the variables the threads are working with variables
you'll need you need to find a way to wait until every thread is done to continue the
execution of the main process.

For this, we'll use the **awaitTermination** method:
```java
service.awaitTermination(long time, TimeUnit timeUnit);
```
What this does is block the thread where the method is called until is interrupted,
a timeout occurs, or the tasks are completed. It's important to set a reasonable amount
of time so if the threads get stuck infinitely the method will interrupt the execution
automatically.

This way, the code is done. Now you know how to implement threads in Java.

*By Christian David Sánchez Sánchez*

*February 28th, 2026*