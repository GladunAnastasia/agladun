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
        int[] array = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            array[i + j] = (array1[i] < array2[j]) ? array1[i++] : (array1[i] == array2[j]) ? array1[i++] : array2[j++];
        }
        if (i != array1.length) {
            System.arraycopy(array1, i, array, i + j, array1.length - i);
        } else {
            System.arraycopy(array2, j, array, i + j, array2.length - j);
        }
        return array;
    }
}

