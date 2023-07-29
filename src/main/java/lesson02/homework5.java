package lesson02;

/*
    Реализовать метод, принимающий 2 символа c1 и c2 и четное число n,
    который возвращает строку, состоящую из символов c1c2 длины n.
    Пример: (c1 = 'a', c2 = 'b', n = 6 => "ababab")
 */
public class homework5 {

    public static String makeStr(char c1, char c2, int n){
        if (n % 2 > 0) {
            return "Число нечётное";
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n/2; i++){
            str.append(c1).append(c2);
        }

        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(makeStr('a', 'b', 8));
    }
}
