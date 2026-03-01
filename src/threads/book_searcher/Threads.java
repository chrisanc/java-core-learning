package threads.book_searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads {
    public static void main(String[] args) {
        // List of names of the available books
        String[] names = new String[]{"test.txt", "lib1.txt", "lib2.txt", "lib3.txt"};
        // Create an atomic variable to modify it concurrently
        AtomicInteger value = new AtomicInteger(0);
        // Create a ExecutorService to define the number of threads and run them
        ExecutorService service = Executors.newFixedThreadPool(names.length);

        // Iterate over the names to get the file name
        for (String s : names) {
            // Execute the function
            service.execute(() -> {
                try {
                    countWords("src/threads/books/" + s, "hola", value);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        service.shutdown();
        // Display the found values
        System.out.println("Found: " + value);
    }

    public static  void countWords(String fileName, String target, AtomicInteger value) throws IOException, InterruptedException {
        // Read the lines of the code
        List<String> lines = Files.readAllLines(Path.of(fileName));
        // Iterate through the lines of the file
        for (String s : lines) {
            for (int i = 0; i <= s.length() - target.length(); i++) {
                if (s.startsWith(target, i)) {
                    increaseCount(value);
                }
            }
        }
    }

    public static synchronized void increaseCount(AtomicInteger value) {
        value.set(value.get() + 1);
    }
}
