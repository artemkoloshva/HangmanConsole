package com.github.artemkoloshva.model.dictionary;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileDictionary implements Dictionary<String>{
    private final List<String> words;
    private final Random random = new Random();

    public FileDictionary(String path) {
        try {
            this.words = Files.readAllLines(Path.of(path)).stream()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();

            if (this.words.isEmpty()) {
                throw new IllegalArgumentException("The dictionary file is empty: " + path);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Dictionary reading error: " + path, e);
        }
    }

    @Override
    public String getRandom() {
        return words.get(random.nextInt(words.size()));
    }
}
