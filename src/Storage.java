import java.util.*;
import java.util.concurrent.Semaphore;

public class Storage {
    private final List<String> buffer = new ArrayList<>();
    private final Semaphore access = new Semaphore(1);
    private final Semaphore full;
    private final Semaphore empty;

    public Storage(int capacity) {
        full = new Semaphore(capacity);
        empty = new Semaphore(0);
    }

    public void produce(String item, int producerId) throws InterruptedException {
        full.acquire();
        access.acquire();

        buffer.add(item);
        System.out.println("[Producer " + producerId + "] Produced: " + item);

        access.release();
        empty.release();
    }

    public void consume(int consumerId) throws InterruptedException {
        empty.acquire();
        access.acquire();

        if (!buffer.isEmpty()) {
            String item = buffer.remove(0);
            System.out.println("\t[Consumer " + consumerId + "] Consumed: " + item);
        }

        access.release();
        full.release();
    }
}
