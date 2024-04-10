import java.util.*;

public class GreedyKnapsack {
    
    static class Item {
        int index;
        double weight;
        double profit;
        
        public Item(int index, double weight, double profit) {
            this.index = index;
            this.weight = weight;
            this.profit = profit;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of objects: ");
        int n = scanner.nextInt();
        
        double[] weights = new double[n];
        double[] profits = new double[n];
        
        System.out.println("Enter the weights of objects:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the profits of objects:");
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the maximum capacity of the knapsack: ");
        int capacity = scanner.nextInt();
        
        long startTime = System.nanoTime();
        KnapsackResult result = knapsack(weights, profits, capacity);
        long endTime = System.nanoTime();
        
        System.out.println("Maximum profit that can be achieved: " + result.maxProfit);
        System.out.println("Objects picked in order:");
        for (int index : result.pickedItems) {
            System.out.println("Object " + index + " (Weight: " + weights[index] + ", Profit: " + profits[index] + ")");
        }
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        
        scanner.close();
    }
    
    static class KnapsackResult {
        double maxProfit; // Changed type to double
        List<Integer> pickedItems;
        
        public KnapsackResult(double maxProfit, List<Integer> pickedItems) {
            this.maxProfit = maxProfit;
            this.pickedItems = pickedItems;
        }
    }
    
    public static KnapsackResult knapsack(double[] weights, double[] profits, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i, weights[i], profits[i]);
        }
        
        Arrays.sort(items, (a, b) -> Double.compare(b.profit / b.weight, a.profit / a.weight));
        
        double maxProfit = 0; // Changed type to double
        List<Integer> pickedItems = new ArrayList<>();
        
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxProfit += item.profit;
                capacity -= item.weight;
                pickedItems.add(item.index);
            } else {
                maxProfit += item.profit * (capacity / item.weight); // Removed casting to int
                break;
            }
        }
        
        return new KnapsackResult(maxProfit, pickedItems);
    }
}
