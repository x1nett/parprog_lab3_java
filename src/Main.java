public class Main {
    public static void main(String[] args) {
        int storageSize = 5;
        int[] producerItems = {5, 3, 4}; // кожен виробник виробляє певну кількість
        int[] consumerItems = {6, 6};    // кожен споживач споживає певну кількість

        Storage storage = new Storage(storageSize);

        // Створення виробників
        for (int i = 0; i < producerItems.length; i++) {
            Producer producer = new Producer(i, producerItems[i], storage);
            new Thread(producer).start();
        }

        // Створення споживачів
        for (int i = 0; i < consumerItems.length; i++) {
            Consumer consumer = new Consumer(i, consumerItems[i], storage);
            new Thread(consumer).start();
        }
    }
}
