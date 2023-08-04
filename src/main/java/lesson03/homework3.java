package lesson03;

/*
Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:

Сортирует его по возрастанию и выводит на экран
Находит минимальное значение в списке и выводит на экран - Minimum is {число}
Находит максимальное значение в списке и выводит на экран - Maximum is {число}
Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

Integer[] arr - список целых чисел

Пример


arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
analyzeNumbers(arr)

// [1, 2, 3, 4, 5, 6, 7, 8, 9]
// Minimum is 1
// Maximum is 9
// Average is = 5
 */

import java.util.Arrays;

class Answer3 {
    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже

        Integer[] arr2 = sort(arr);

        System.out.println(Arrays.toString(arr2));
        System.out.println("Minimum is " + arr2[0]);
        System.out.println("Maximum is " + arr2[arr2.length - 1]);
        System.out.println("Average is = " + getAverage(arr2));
    }

    private static int getAverage(Integer[] arr) {
        Integer sum = 0;

        for (Integer n : arr) {
            sum += n;
        }

        return sum / arr.length;
    }

    private static Integer[] sort(Integer[] arr) {
        for (int out = arr.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if(arr[in] > arr[in + 1]) {
                    int temp = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = temp;
                }
            }
        }
        return arr;
    }
}


public class homework3 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer3 ans = new Answer3();
        ans.analyzeNumbers(arr);
    }
}
