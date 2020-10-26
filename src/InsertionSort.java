public class InsertionSort {

    public int Sort(int[] A, int length, int index) {

        for(int j = 1; j < length; j++) {

            int key = A[j];
            int i = j-1;

            while ( (i > -1) && (A[i] > key) ) {
                A[i+1] = A[i];
                i = i-1;
            }

            A[i+1] = key;
        }

        return(A[index]);
    }

}
