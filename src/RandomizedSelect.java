public class RandomizedSelect {

    public int Sort(int[] A, int length, int index) {

        int start = 0;
        int end = length - 1;

        RandomizedSort(A, start, end, index);

        return(A[index]);
    }

    private int RandomizedSort(int[] A, int start, int end, int i) {

        if (start == end) {
            return(A[start]);
        }

        int q = RandomizedPartition(A, start, end);

        if (i == q) {
            return A[q];
        }
        else if (i < q) {
            return RandomizedSort(A, start, q - 1, i);
        }
        else {
            return RandomizedSort(A, q + 1, end, i);
        }
    }

    private int RandomizedPartition(int[] A, int start, int end) {

        int i = (int) (Math.random() * (end - start) + start);

        int temp = A[end];
        A[end] = A[i];
        A[i] = temp;

        return (Partition(A, start, end));
    }

    private int Partition(int[] A, int start, int end) {

        int x = A[end];
        int i = start - 1;

        for(int j = start; j < end; j++) {
            if (A[j] <= x) {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[end];
        A[end] = temp;

        return(i + 1);
    }
}
