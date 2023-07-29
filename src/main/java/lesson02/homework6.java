package lesson02;

/*
    Реализовать метод, принимающий строку и проверяющий, является ли она палиндромом
 */

public class homework6 {
    public static boolean isPalindrom(String str){
        int lenStr = str.length();
        int i = 0;
        boolean flag = true;

        while (i < lenStr / 2){

            char first = str.charAt(i);
            char last = str.charAt(lenStr - i - 1);

            System.out.println(first + "-" + last);

            if (first != last) {
                flag = false;
                break;
            }

            i++;
        }

        return flag;
    }

    public static void main(String[] args) {

        String s = "1233221";

        System.out.println(s);

        if (isPalindrom(s))
            System.out.println("Палиндром");
        else
            System.out.println("Не палиндром");
    }
}
