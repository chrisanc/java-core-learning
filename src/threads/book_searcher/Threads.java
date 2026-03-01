package threads.book_searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads {
    public static void main(String[] args) {
        // List of names of the available books
        List<Path> names;
        try {
            names = getFilesFromDir("src/threads/book_searcher/books/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create an atomic variable to modify it concurrently
        AtomicInteger value = new AtomicInteger(0);
        // Create a ExecutorService to define the number of threads and run them
        ExecutorService service = Executors.newFixedThreadPool(names.size());

        // Iterate over the names to get the file name
        for (Path s : names) {
            // Execute the function
            service.execute(() -> {
                try {
                    countWords(s, "a", value);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        // Shutdown the Executor
        service.shutdown();

        // Wait till the threads finish their execution
        try {
            service.awaitTermination((long) 1.5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Error " + e);
            return;
        }
        // Display the found values
        System.out.println("Found: " + value);
    }

    public static void countWords(Path filePath, String target, AtomicInteger value) throws IOException {
        // Define a list to save the lines of the file
        // Read the lines of the code
        List<String> lines = Files.readAllLines(filePath);
        // Iterate through the lines of the file
        for (String s : lines) {
            // Iterate over each line to find the targeted word in the line
            for (int i = 0; i <= s.length() - target.length(); i++) {
                // If the target matches the substring, we increase the counter
                if (s.startsWith(target, i)) {
                    increaseCount(value);
                }
            }
        }
    }

    public static List<Path> getFilesFromDir(String dirName) throws IOException {
        return Files.list(Path.of((dirName))).toList();
    }

    public static synchronized void increaseCount(AtomicInteger value) {
        /*
        * Get the value and increase it by 1
        * */
        value.set(value.get() + 1);
    }
}
