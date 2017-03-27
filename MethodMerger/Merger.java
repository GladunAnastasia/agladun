import java.util.Arrays;

public class Merger {
    public static void main(String[] args) {
//        int[] array1 = {1, 2, 3, 3, 3, 4, 5};
//        int[] array2 = {1, 2, 3, 3};
        int[] array1 = {1,3,5,6,7};
        int[] array2 = {1,2,3,4,6,8,9};
        System.out.println(Arrays.toString(sort(array1, array2)));
    }

    public static int[] sort(int[] array1, int[] array2) {
        int length = array1.length + array2.length;
        int minLength = (array1.length > array2.length) ? array2.length : array1.length;
        int[] array = new int[length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (k < length) {
            if (((array1.length > array2.length) ? j : i) >= minLength) {
                array[k] = (array1.length > array2.length) ? array1[j] : array2[j];
                k++;
                j++;
            } else {
                if (array1[i] < array2[j]) {
                    array[k] = array1[i];
                    i++;
                    k++;
                } else if (array1[i] > array2[j]) {
                    array[k] = array2[j];
                    j++;
                    k++;
                } else {
                    array[k] = array1[i];
                    array[k + 1] = array2[j];
                    i++;
                    j++;
                    k += 2;
                }
            }
        }
        return array;
    }
}

