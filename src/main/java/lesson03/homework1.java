package lesson03;

import java.util.Arrays;

/*
Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел a
и реализует алгоритм сортировки слиянием.
Метод должен возвращать отсортированный массив.

Пример

a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]
 */
class MergeSort {
    public static int[] mergeSort(int[] a) {
        // Напишите свое решение ниже

        if (a.length < 2) {
            return a;
        }

        int[] leftArr = new int[a.length / 2];
        System.arraycopy(a, 0, leftArr, 0, a.length / 2);

        int[] rightArr = new int[a.length - a.length / 2];
        System.arraycopy(a, a.length / 2, rightArr, 0, a.length - a.length / 2);

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return mergeArray(leftArr, rightArr);
    }

    private static int[] mergeArray(int[] leftArr, int[] rightArr) {
        int joinLenght = leftArr.length + rightArr.length;
        int[] joinArr = new int[joinLenght];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < joinLenght; i++) {
            if (leftIndex == leftArr.length) {
                joinArr[i] = rightArr[rightIndex];
                rightIndex++;
            } else if (rightIndex == rightArr.length) {
                joinArr[i] = leftArr[leftIndex];
                leftIndex++;
            } else if (leftArr[leftIndex] < rightArr[rightIndex]) {
                joinArr[i] = leftArr[leftIndex];
                leftIndex++;
            } else {
                joinArr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
        return joinArr;
    }
}

public class homework1 {
    public static void main(String[] args) {
        int[] a;
        a = new int[]{5, 1, 6, 2, 3, 4};

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}
