public class Producer implements Runnable {
    private final int id;
    private final String[] items;
    private final Storage storage;

    public Producer(int id, String[] items, Storage storage) {
        this.id = id;
        this.items = items;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (String item : items) {
                storage.add(item, id);
                Thread.sleep(200); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
