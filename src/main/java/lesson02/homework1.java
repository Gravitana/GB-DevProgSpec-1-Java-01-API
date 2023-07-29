package lesson02;

import java.util.Arrays;
import java.util.Objects;

public class homework1 {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже

        PARAMS = PARAMS.replaceAll("\"", "").replaceAll(", ", ",");
        PARAMS = PARAMS.substring(PARAMS.indexOf("{") + 1, PARAMS.indexOf("}"));

        String[] arrParams = PARAMS.split(",");

        StringBuilder newQuery = new StringBuilder(QUERY);

        boolean flag = false;

        for (String item : arrParams) {
            String[] arrItem = item.split(":");

            if (!arrItem[1].equals("null")) {
                if (flag)
                    newQuery.append(" and ");

                newQuery.append(arrItem[0]).append("=").append("'").append(arrItem[1]).append("'");
            }
            flag = true;
        }

        return newQuery;
    }

    public static void main(String[] args) {

        String query = "select * from students where ";
        String params = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

        System.out.println(answer(query, params));
    }

}
