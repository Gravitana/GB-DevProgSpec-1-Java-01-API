package lesson05;

import java.util.*;

public class Homework {
    /**
     * Дан текст. Нужно отсортировать слова по длине (по возрастанию) и вывести статистику на экран.
     * Регистр слова не имеет значения. Формат вывода произвольный.
     * Программа-минимум:
     * 1. Слова, состоящие из дефисов, считаем одним словом. Т.е. каких-то - одно слово из 8 символов.
     * 2. Точки и запятые не должны входить в статистику.
     *
     * Доп. задание
     * 1. * Не включать дефис в длину слова. Т.е. каких-то - одно слово из 7 символов.
     *
     * Пример:
     *
     * Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB.
     * Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.
     *
     * 1 -> [и, в]
     * 2 -> [он, из, gb, не]
     * 3 -> [мой, для]
     * 4 -> [слов, того, себе]
     * 5 -> [текст, нужен, чтобы, несет, набор]
     * ...
     */
    static void printStats(String text, Boolean includeHyphen) {
        // 1. Split текста, приведение его к нижнему регистру, удаление запятых и точек.
        // 2. Сбор структуры со статистикой.
        Map<Integer, List<String>> stats = new HashMap<>(); // Структура, в которой ключ - длина слова, значение - список таких слов.

        String tempTest = text.toLowerCase()
                .replaceAll("[,.]", "")
                .replace(" - ", " ")
                .replaceAll("\\s+", " ");

        String[] mas = tempTest.split(" ");

        for (String word: mas) {
            int len = word.length();

            if (!includeHyphen && word.contains("-"))
                len -= 1;

            List<String> strList = stats.get(len);

            if (strList == null)
                strList = new LinkedList<>();

            if (!strList.contains(word)) {
                strList.add(word);
                stats.put(len, strList);
            }

            stats.put(len, strList);
        }

        for (Map.Entry<Integer, List<String>> entry : stats.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key + " -> " + value);
        }

    }

    public static void main(String[] args) {
        String text = "Это - мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB. " +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        Scanner console = new Scanner(System.in);
        System.out.print("Включать дефис в длину слова? 0-Нет: ");
        int hyphen = console.nextInt();

        printStats(text, hyphen != 0);
    }
}
