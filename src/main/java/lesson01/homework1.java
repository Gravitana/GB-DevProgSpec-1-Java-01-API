package lesson01;

public class homework1 {
//    Вычислить n-ое треугольного число(сумма чисел от 1 до n),
//    n! (произведение чисел от 1 до n).

    public static int countNTriangle(int n){
        // Введите свое решение ниже
        int triangle = 0;

        for (int i = 1; i <= n; i++) {
            triangle += i;
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(countNTriangle(4));
    }
}
