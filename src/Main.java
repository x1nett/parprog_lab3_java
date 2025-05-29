public class Main {
    public static void main(String[] args) {
        int storageSize = 5;

        // Дані для виробників
        String[][] producerData = {
            {"A1", "A2", "A3"},
            {"B1", "B2"},
            {"C1", "C2", "C3", "C4"}
        };
        
        int[] consumerNeeds = {4, 5};

        Storage storage = new Storage(storageSize);

        for (int i = 0; i < producerData.length; i++) {
            Producer producer = new Producer(i, producerData[i], storage);
            new Thread(producer).start();
        }

        // Запуск споживачів
        for (int i = 0; i < consumerNeeds.length; i++) {
            Consumer consumer = new Consumer(i, consumerNeeds[i], storage);
            new Thread(consumer).start();
        }
    }
}
