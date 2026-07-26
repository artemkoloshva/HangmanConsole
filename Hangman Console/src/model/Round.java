package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Round {
    private String _word;
    private Set<Character> _letters;
    private int _errorsCount;
    private boolean _isWin;

    public Round(){
        clear();
    }

    public void clear(){
        _word = "";
        _letters = new HashSet<>();
        _errorsCount = 0;
        _isWin = false;
    }

    public void setWord(String word){
        _word = word;
    }

    public String getWord(){
        return _word;
    }

    public void addLetter(Character letter){
        _letters.add(letter);
    }

    public boolean hasLetter(Character letter){
        return _letters.contains(letter);
    }

    public int getErrors(){
        return _errorsCount;
    }

    public void addError(){
        _errorsCount++;
    }

    public boolean isWin(){
        return _isWin;
    }
}
