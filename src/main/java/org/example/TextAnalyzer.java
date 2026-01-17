package org.example;

import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] sentences = text.split("[.!?]+");

        int count = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }

    public String findMostFrequentWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        String lowerText = text.toLowerCase();
        String cleanedText = lowerText.replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "");
        String[] words = cleanedText.trim().split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        String mostFrequent = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }
}