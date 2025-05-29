public class Consumer implements Runnable {
    private final int id;
    private final int itemCount;
    private final String[] buffer;
    private final Storage storage;

    public Consumer(int id, int itemCount, Storage storage) {
        this.id = id;
        this.itemCount = itemCount;
        this.storage = storage;
        this.buffer = new String[itemCount];
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                buffer[i] = storage.take(id);
                Thread.sleep(500); // Для демонстрації
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
