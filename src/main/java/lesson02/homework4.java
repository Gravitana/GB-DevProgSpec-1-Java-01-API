/*
Возьмите код от калькулятора с прошлого урока.

К этому калькулятору нужно добавить логирование.

Логи запишите в файл log.txtв формате:

"гггг-мм-дд чч:мм User entered the first operand = {первое число}"
"гггг-мм-дд чч:мм User entered the operation = {оператор}"
"гггг-мм-дд чч:мм User entered the second operand = {второе число}"
"гггг-мм-дд чч:мм Result is {результат}"
 */
package lesson02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class homework4 {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
        int a = 0;
        char op = ' ';
        int b = 0;

        a = 3;
        op = '+';
        b = 7;

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}

class Calculator {

//    Date date = new Date();

    File file = new File("src/main/java/lesson02/log4.txt");
    String str = "";

    public int calculate(char op, int a, int b) throws IOException {
        // Введите свое решение ниже

        int result;

        switch (op) {
            case '+':
                result = add(a, b);
                break;
            case '-':
                result = minus(a, b);
                break;
            case '*':
                result = mult(a, b);
                break;
            case '/':
                result = divide(a, b);
                break;
            default:
                throw new IllegalArgumentException("Некорректный оператор: " + op);
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            str = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", timestamp) +
                    "User entered the first operand = " + a + "\n" +
                    String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", timestamp) +
                    "User entered the operation = " + op + "\n" +
                    String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", timestamp) +
                    "User entered the second operand = " + b + "\n" +
                    String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM ", timestamp) +
                    "Result is " + result;
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private int divide(int a, int b) {
        if (b != 0) return a / b;
        return -1;
    }

    private int mult(int a, int b) {
        return a * b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int add(int a, int b) {
        return a + b;
    }
}
