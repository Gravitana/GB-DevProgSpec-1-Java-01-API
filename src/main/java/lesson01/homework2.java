package lesson01;

public class homework2 {
//    Напишите функцию printPrimeNums, которая выведет на экран все простые числа от 1 до 1000, каждое на новой строке.
    public static void printPrimeNums(){
        // Напишите свое решение ниже

        for (int i = 1; i <= 1000; i++) {
            int prime = i;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = 0;
                    break;
                }
            }

            if (prime > 0) {
                System.out.println(prime);
            }
        }
    }

    public static void main(String[] args) {
        printPrimeNums();
    }
}
