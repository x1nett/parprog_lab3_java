public class Consumer implements Runnable {
    private final int id;
    private final int itemCount;
    private final Storage storage;

    public Consumer(int id, int itemCount, Storage storage) {
        this.id = id;
        this.itemCount = itemCount;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                storage.consume(id);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
