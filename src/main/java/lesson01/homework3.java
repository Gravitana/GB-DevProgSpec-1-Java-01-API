package lesson01;

public class homework3 {

//    Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /) над двумя числами и возвращать результат.
//    В классе должен быть метод calculate, который принимает оператор и значения аргументов и возвращает результат вычислений.
//    При неверно переданном операторе, программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".

    // Не сдал

    public static int calculate(char op, int a, int b) {
        switch (op) {
            case '+':
                return add(a, b);
            case '-':
                return minus(a, b);
            case '*':
                return mult(a, b);
            case '/':
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Некорректный оператор: " + op);
        }
    }

    private static int divide(int a, int b) {
        if (b != 0) return a / b;
        return -1;
    }

    private static int mult(int a, int b) {
        return a * b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

    }
}

