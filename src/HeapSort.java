public class HeapSort {

    int n;

    public int Sort(int[] A, int length, int index) {

        n = A.length;
        BuildMaxHeap(A);

        for (int i = length - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            n -= 1;
            MaxHeapify(A, 0);
        }

        return (A[index]);
    }

    private void BuildMaxHeap(int[] A) {

        for (int i = Parent(n); i >= 0; i--) {
            MaxHeapify(A, i);
        }

    }

    private void MaxHeapify(int[] A, int i) {

        int largest;
        int l = Left(i);
        int r = Right(i);
        boolean isParentLargest = true;

        //check left side
        if ( (l < n) && (A[l] > A[i]) ){
            largest = l;
            isParentLargest = false;
        }
        //parent is larger
        else {
            largest = i;
        }

        //check right side
        if ( (r < n) && (A[r] > A[largest]) ){
            largest = r;
            isParentLargest = false;
        }

        if(!isParentLargest) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            MaxHeapify(A, largest);
        }
    }

    private int Parent(int i) {
        return ((i / 2) - 1);
    }

    private int Left(int i) {
        return (2 * i + 1);
    }

    private int Right(int i) {
        return (2 * i + 2);
    }

}
