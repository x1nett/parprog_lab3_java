public class Main {
    public static void main(String[] args) {
        int storageSize = 5;
        int[] producerItems = {5, 3, 4}; 
        int[] consumerItems = {6, 6};    

        Storage storage = new Storage(storageSize);

        for (int i = 0; i < producerItems.length; i++) {
            Producer producer = new Producer(i, producerItems[i], storage);
            new Thread(producer).start();
        }

        for (int i = 0; i < consumerItems.length; i++) {
            Consumer consumer = new Consumer(i, consumerItems[i], storage);
            new Thread(consumer).start();
        }
    }
}
