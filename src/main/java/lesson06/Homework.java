package lesson06;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        int minFloor;
        int maxFloor;
        String message;
        boolean doAction = true;

        Scanner console = new Scanner(System.in);

        System.out.println("Создаём лифт");
        System.out.print("Введите номера минимального и максимального этажей: ");
        minFloor = console.nextInt();
        maxFloor = console.nextInt();

        Lift lift = new Lift(minFloor, maxFloor);

        System.out.printf("Отлично! Мы в лифте на %d-м этаже. ", lift.getCurrentFloor());
        System.out.println("Давайте покатаемся!");

        while (doAction) {
            System.out.print("Введите номер этажа или 0 для выхода из лифта: ");
            int newFloor = console.nextInt();

            if (newFloor == 0) {
                message = "Поездка окончена.";
                doAction = false;
            } else {
                message = lift.move(newFloor);
            }

            System.out.println(message);
        }
        System.out.printf("Вы вышли на %d-м этаже.", lift.getCurrentFloor());
    }
}
