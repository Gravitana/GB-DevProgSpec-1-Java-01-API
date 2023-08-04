package lesson03;

/*
Напишите функцию removeEvenNumbers, которая принимала бы произвольный список целых чисел,
удаляла бы из него четные числа и выводила список без четных чисел.
Напишите свой код в методе removeEvenNumbers класса Answer.
Метод removeEvenNumbers принимает на вход один параметр:

Integer[] arr - список целых чисел

Пример


arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
removeEvenNumbers(arr);

// [1, 3, 5, 7, 9]

arr = new Integer[]{2, 4, 6, 8};
removeEvenNumbers(arr);

// []
*/

import java.util.ArrayList;
import java.util.Arrays;

class Answer2 {
    public static void removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже

        ArrayList<Integer> arr2 = new ArrayList<>();

        for (Integer n : arr) {
            if (n % 2 != 0) {
                arr2.add(n);
            }
        }

        arr = arr2.toArray(new Integer[0]);

        System.out.println(Arrays.toString(arr));
    }
}

public class homework2 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer2 ans = new Answer2();
        ans.removeEvenNumbers(arr);
    }
}
