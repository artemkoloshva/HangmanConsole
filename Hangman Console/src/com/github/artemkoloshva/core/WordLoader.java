package com.github.artemkoloshva.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordLoader {
    private final List<String> words;

    public WordLoader() {
        words = new ArrayList<>();
    }

    public WordLoader(String filePath) {
        words = new ArrayList<>();

        load(filePath);
    }

    public String getWord(int index) {
        return words.get(index);
    }

    public int getWordsLength() {
        return words.size();
    }

    public void load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
