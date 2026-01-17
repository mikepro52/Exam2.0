package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    private TextAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new TextAnalyzer();
    }

    @Test
    @DisplayName("Тест подсчета слов в пустой строке")
    void testCountWordsEmpty() {
        assertEquals(0, analyzer.countWords(""));
        assertEquals(0, analyzer.countWords("   "));
        assertEquals(0, analyzer.countWords(null));
    }

    @Test
    @DisplayName("Тест подсчета слов в простых строках")
    void testCountWordsSimple() {
        assertEquals(1, analyzer.countWords("Hello"));
        assertEquals(3, analyzer.countWords("Hello world test"));
        assertEquals(5, analyzer.countWords("Это тестовый текст для проверки"));
    }

    @Test
    @DisplayName("Тест подсчета слов с множественными пробелами")
    void testCountWordsWithMultipleSpaces() {
        assertEquals(4, analyzer.countWords("Слово1  слово2   слово3    слово4"));
    }

    @Test
    @DisplayName("Тест подсчета предложений в пустой строке")
    void testCountSentencesEmpty() {
        assertEquals(0, analyzer.countSentences(""));
        assertEquals(0, analyzer.countSentences("   "));
        assertEquals(0, analyzer.countSentences(null));
    }

    @Test
    @DisplayName("Тест подсчета простых предложений")
    void testCountSentencesSimple() {
        assertEquals(1, analyzer.countSentences("Одно предложение."));
        assertEquals(2, analyzer.countSentences("Первое. Второе!"));
        assertEquals(3, analyzer.countSentences("Что? Да! Конечно."));
    }

    @Test
    @DisplayName("Тест подсчета предложений с комплексным текстом")
    void testCountSentencesComplex() {
        String text = "Привет! Как дела? Все хорошо. А у тебя?";
        assertEquals(4, analyzer.countSentences(text));
    }

    @Test
    @DisplayName("Тест поиска частого слова в пустой строке")
    void testFindMostFrequentWordEmpty() {
        assertEquals("", analyzer.findMostFrequentWord(""));
        assertEquals("", analyzer.findMostFrequentWord("   "));
        assertEquals("", analyzer.findMostFrequentWord(null));
    }

    @Test
    @DisplayName("Тест поиска частого слова в простом тексте")
    void testFindMostFrequentWordSimple() {
        String text = "яблоко яблоко яблоко груша груша";
        assertEquals("яблоко", analyzer.findMostFrequentWord(text));
    }

    @Test
    @DisplayName("Тест игнорирования регистра при поиске частого слова")
    void testFindMostFrequentWordIgnoreCase() {
        String text = "Слово слово СЛОВО сЛоВо";
        assertEquals("слово", analyzer.findMostFrequentWord(text));
    }

    @Test
    @DisplayName("Тест учета знаков препинания при поиске частого слова")
    void testFindMostFrequentWordWithPunctuation() {
        String text = "Привет, привет! Как дела? Привет еще раз.";
        assertEquals("привет", analyzer.findMostFrequentWord(text));
    }

    @Test
    @DisplayName("Интеграционный тест всех методов")
    void testIntegration() {
        String text = "Тест. Тест тест! Тест?";
        assertEquals(4, analyzer.countWords(text));
        assertEquals(3, analyzer.countSentences(text));
        assertEquals("тест", analyzer.findMostFrequentWord(text));
    }

    @Test
    @DisplayName("Тест на реальном примере текста")
    void testRealExample() {
        String text = "Текст для анализа - это важный инструмент в программировании. " +
                "Программа анализирует текст и выдает статистику! Сколько слов здесь? " +
                "Сколько предложений? Какое слово встречается чаще всего? " +
                "Повторяющиеся слова помогают проверить работу алгоритма. " +
                "Слова, слова, слова... анализ, Анализ, АНАЛИЗ!";

        assertEquals(37, analyzer.countWords(text));
        assertEquals(8, analyzer.countSentences(text));
        assertEquals("слова", analyzer.findMostFrequentWord(text));
    }

    @Test
    @DisplayName("Тест граничных случаев")
    void testEdgeCases() {
        assertEquals(0, analyzer.countWords("...!!!???"));
        assertEquals(0, analyzer.countSentences("...!!!???"));
        assertEquals("", analyzer.findMostFrequentWord("...!!!???"));
    }
}