package core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordLoader {
    private final List<String> _words;

    public WordLoader(String filePath) {
        _words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    _words.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public String getWord(int index){
        return _words.get(index);
    }

    public int getWordsLength(){
        return _words.size();
    }
}
