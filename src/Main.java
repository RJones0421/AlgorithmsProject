import java.util.Arrays;

public class Main {



    private static int insertionTime;
    private static int heapsortTime;
    private static int randomizedTime;

    public static void main(String[] args){

        float[] aInsertionTime = new float[20];
        float[] aHeapsortTime = new float[20];
        float[] aRandomizedTime = new float[20];

        for (int i = 1; i <= 20; i++) {
            int length = i * 10000;
            int index = (2 * length) / 3;

            ResetTime();

            System.out.println("\nIndex values for array of length " + length + ":");

            for(int j = 0; j < 5; j++) {

                int[] array = CreateArray(length);

                Insertion(Arrays.copyOf(array, array.length), array.length, index);
                Heap(Arrays.copyOf(array, array.length), array.length, index);
                Randomized(Arrays.copyOf(array, array.length), array.length, index);
            }

            aInsertionTime[i-1] = (float) insertionTime / 5;
            aHeapsortTime[i-1] = (float) heapsortTime / 5;
            aRandomizedTime[i-1] = (float) randomizedTime / 5;
        }

        System.out.println("\nInsertion Sort Times:\t" + Arrays.toString(aInsertionTime));
        System.out.println("Heapsort Times:\t\t\t" + Arrays.toString(aHeapsortTime));
        System.out.println("Randomized Sort Times:\t" + Arrays.toString(aRandomizedTime));

    }

    private static int[] CreateArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 40000);
        }

        return(array);
    }

    private static void Insertion(int[] A, int length, int index) {
        InsertionSort insertionSort = new InsertionSort();

        long t1 = System.currentTimeMillis();
        int value = insertionSort.Sort(A, length, index);
        long t2 = System.currentTimeMillis();

        System.out.print(value + "\t");

        insertionTime = (int) (insertionTime + (t2 - t1));
    }

    private static void Heap(int[] A, int length, int index) {
        HeapSort heapSort = new HeapSort();

        long t1 = System.currentTimeMillis();
        int value = heapSort.Sort(A, length, index);
        long t2 = System.currentTimeMillis();

        System.out.print(value + "\t");

        heapsortTime = (int) (heapsortTime + (t2 - t1));
    }

    private static void Randomized(int[] A, int length, int index) {
        RandomizedSelect randomizedSelect = new RandomizedSelect();

        long t1 = System.currentTimeMillis();
        int value = randomizedSelect.Sort(A, length, index);
        long t2 = System.currentTimeMillis();

        System.out.println(value);

        randomizedTime = (int) (randomizedTime + (t2 - t1));
    }

    private static void ResetTime() {
        insertionTime = 0;
        heapsortTime = 0;
        randomizedTime = 0;
    }

}
