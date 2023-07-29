/*
Внутри класса Answer напишите метод answer, который распарсит json и, используя StringBuilder, создаст строки вида:

Студент [фамилия] получил [оценка] по предмету [предмет].
На вход метода answer подаются аргументы:

String JSON
String ELEMENT1
String ELEMENT2
String ELEMENT3
Пример:


JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
ELEMENT1 = "Студент ";
ELEMENT2 = " получил ";
ELEMENT3 = " по предмету ";

// Студент Иванов получил 5 по предмету Математика
// Студент Петрова получил 4 по предмету Информатика
// Студент Краснов получил 5 по предмету Физика
 */

package lesson02;

import java.util.ArrayList;
import java.util.List;

public class homework3 {

    public static StringBuilder answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3){
        // Напишите свое решение ниже
        int countEl = JSON.length() - JSON.replace(String.valueOf("}"), "").length();
        String[] data = new String[countEl];

        JSON = JSON.replaceAll("\"", "").replaceAll(", ", ",");

        boolean flag = true;
        int oldFirst = 0;
        int i = 0;

        while (flag) {
            int first = JSON.indexOf("{", oldFirst) + 1;
            int last = JSON.indexOf("}", oldFirst);

            if (first > 0 && last > 0) {
                String dataTemp = JSON.substring(first, last);
                data[i++] = dataTemp;
            } else {
                flag = false;
            }

            oldFirst = last + 1;
        }

        StringBuilder str = new StringBuilder();
        String item = "";

        for(Object element : data) {
            String[] arr = element.toString().split(",");
            item = arr[0];
            str.append(ELEMENT1).append(item.substring(item.indexOf(":")+1));
            item = arr[1];
            str.append(ELEMENT2).append(item.substring(item.indexOf(":")+1));
            item = arr[2];
            str.append(ELEMENT3).append(item.substring(item.indexOf(":")+1)).append("\n");
        }
        return str;
    }

    public static void main(String[] args) {
        String JSON = "";
        String ELEMENT1 = "";
        String ELEMENT2 = "";
        String ELEMENT3 = "";

        JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        ELEMENT1 = "Студент ";
        ELEMENT2 = " получил ";
        ELEMENT3 = " по предмету ";

        System.out.println(answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3));

    }
}
