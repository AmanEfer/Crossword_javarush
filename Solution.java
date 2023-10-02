package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same").forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> detectedWords = new ArrayList<>();

        int yLineLength = crossword.length;
        int xLineLength = crossword[0].length;

        for (String currentWord : words) {
            int wordLength = currentWord.length() - 1;
            char firstLetter = currentWord.charAt(0);
            char lastLetter = currentWord.charAt(wordLength);
            int startX;
            int startY;
            int endX;
            int endY;
            int iTemp;
            int jTemp;

            for (int i = 0; i < yLineLength; i++) {
                for (int j = 0; j < xLineLength; j++) {
                    char currentFirstLetter = (char) crossword[i][j];

                    if (currentFirstLetter == firstLetter) {
                        startX = j;
                        startY = i;

                        if (j + wordLength < xLineLength) {
                            endX = j + wordLength;
                            endY = i;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp][jTemp++]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if ((j + wordLength < xLineLength) && (i + wordLength < yLineLength)) {
                            endX = j + wordLength;
                            endY = i + wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp++][jTemp++]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if (i + wordLength < yLineLength) {
                            endX = j;
                            endY = i + wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp++][jTemp]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if ((j - wordLength >= 0) && (i + wordLength < yLineLength)) {
                            endX = j - wordLength;
                            endY = i + wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp++][jTemp--]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if (j - wordLength >= 0) {
                            endX = j - wordLength;
                            endY = i;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp][jTemp--]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if ((j - wordLength >= 0) && (i - wordLength >= 0)) {
                            endX = j - wordLength;
                            endY = i - wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp--][jTemp--]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if (i - wordLength >= 0) {
                            endX = j;
                            endY = i - wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp--][jTemp]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }

                        if ((j + wordLength < xLineLength) && (i - wordLength >= 0)) {
                            endX = j + wordLength;
                            endY = i - wordLength;
                            char currentLastLetter = (char) crossword[endY][endX];

                            if (currentLastLetter == lastLetter) {
                                iTemp = i;
                                jTemp = j;
                                StringBuilder builder = new StringBuilder();
                                for (int k = 0; k <= wordLength; k++) {
                                    builder.append((char) crossword[iTemp--][jTemp++]);
                                }
                                if (builder.toString().equals(currentWord)) {
                                    detectedWords.add(createWord(currentWord, startX, startY, endX, endY));
                                }
                            }
                        }
                    }
                }
            }
        }
        return detectedWords;
    }

    private static Word createWord(String text, int startX, int startY, int endX, int endY) {
        Word word = new Word(text);
        word.setStartPoint(startX, startY);
        word.setEndPoint(endX, endY);
        return word;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
