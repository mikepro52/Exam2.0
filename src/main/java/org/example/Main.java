package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для анализа:");
        String text = scanner.nextLine();

        TextAnalyzer analyzer = new TextAnalyzer();

        System.out.println("\nРезультаты анализа:");
        System.out.println("Количество слов: " + analyzer.countWords(text));
        System.out.println("Количество предложений: " + analyzer.countSentences(text));
        System.out.println("Самое частое слово: " + analyzer.findMostFrequentWord(text));

        scanner.close();
    }
}