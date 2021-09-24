package behavioral.strategy;

import java.util.Arrays;

public class StrategyRunner {
    public static void main(String[] args) {

        var strategyClient = new StrategyClient();

        int [] array = {5,6,7,82,55,3,17,44};
        strategyClient.setStrategy(new SelectionSort());
        strategyClient.executeStrategy(array);

        int [] array1 = {9,8,7,6,5,4,3,2,1,0};
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(array1);

        int [] array2 = {1,5,63,3,17,44};
        strategyClient.setStrategy(new InsertSort());
        strategyClient.executeStrategy(array2);

    }
}

//Context
class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("Before : " + Arrays.toString(arr));
        int changeCounter = 0;
        do {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changeCounter++;
                }
            }
        } while (changeCounter > 0);
        System.out.println("After sort + " + Arrays.toString(arr));

    }
}

class SelectionSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("Before : " + Arrays.toString(arr));
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int i = barrier; i < arr.length; i++) {
                if (arr[i] < arr[barrier]) {
                    int temp = arr[i];
                    arr[i] = arr[barrier];
                    arr[barrier] = temp;
                }
            }

        }
        System.out.println("After sort + " + Arrays.toString(arr));
    }
}

class InsertSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Insert sort");
        System.out.println("Before : " + Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        System.out.println("After sort + " + Arrays.toString(arr));
    }
}
