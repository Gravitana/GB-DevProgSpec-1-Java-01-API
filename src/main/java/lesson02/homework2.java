/*
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

int[] arr - числовой массив

После каждой итерации, ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.

Пример


arr = new int[]{9, 4, 8, 3, 1};
sort(arr)

// При чтении лог-файла получим:
2023-05-19 07:53 [4, 8, 3, 1, 9]
2023-05-19 07:53 [4, 3, 1, 8, 9]
2023-05-19 07:53 [3, 1, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]

*/

package lesson02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class homework2 {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        Date date = new Date();

        File file = new File("src/main/java/lesson02/log2.txt");

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            for (int out = mas.length - 1; out >= 1; out--) {
                boolean flag = false;
                for (int in = 0; in < out; in++) {
                    if(mas[in] > mas[in + 1]) {
                        int temp = mas[in];
                        mas[in] = mas[in + 1];
                        mas[in + 1] = temp;
                        flag = true;
                    }
                }
                if (flag) {
                    String str = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", date) + Arrays.toString(mas) + "\n";
                    writer.write(str);
                }
            }
            String str = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", date) + Arrays.toString(mas) + "\n";
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        int[] arr = {};

        arr = new int[]{9, 4, 8, 3, 1};
        sort(arr);

//        System.out.println(Arrays.toString(arr));

    }
}