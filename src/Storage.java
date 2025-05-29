import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Storage {
    private final int capacity;
    private final Queue<String> buffer = new LinkedList<>();
    private final Semaphore access = new Semaphore(1);
    private final Semaphore full;
    private final Semaphore empty;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.full = new Semaphore(capacity);
        this.empty = new Semaphore(0);
    }

    public void add(String item, int producerId) throws InterruptedException {
        full.acquire();
        access.acquire();

        buffer.add(item);
        System.out.println("[Producer " + producerId + "] Produced: " + item);

        access.release();
        empty.release();
    }

    public String take(int consumerId) throws InterruptedException {
        empty.acquire();
        access.acquire();

        String item = buffer.poll();
        System.out.println("\t[Consumer " + consumerId + "] Consumed: " + item);

        access.release();
        full.release();
        return item;
    }
}
