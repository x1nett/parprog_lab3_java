public class Producer implements Runnable {
    private final int id;
    private final int itemCount;
    private final Storage storage;

    public Producer(int id, int itemCount, Storage storage) {
        this.id = id;
        this.itemCount = itemCount;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                String item = "Item_P" + id + "_" + i;
                storage.produce(item, id);
                Thread.sleep(200); // для наочності
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
