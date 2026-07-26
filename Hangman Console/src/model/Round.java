package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Round {
    private List<Character> _word;
    private Set<Character> _errorLetters; // Заменили List на Set
    private Set<Character> _usedLetters;
    private int _errorsCount;
    private boolean _isWin;

    public Round(){
        clear();
    }

    public void clear(){
        _word = new ArrayList<>();
        _errorLetters = new HashSet<>(); // Инициализируем Set
        _usedLetters = new HashSet<>();
        _errorsCount = 0;
        _isWin = false;
    }

    public void setWord(String word){
        for(Character letter : word.toCharArray()){
            _word.add(letter);
        }
    }

    public Character getWordLetter(int index){
        return _word.get(index);
    }

    public List<Character> getWordLetters(){
        return new ArrayList<>(_word);
    }

    public int getWordLength(){
        return _word.size();
    }

    public boolean hasLetter(Character letter){
        for (Character let : _word){
            if(let.equals(letter)){
                return true;
            }
        }
        return false;
    }

    public void addUsedLetter(Character letter){
        _usedLetters.add(letter);
    }

    public boolean isUsedLetter(Character letter){
        return _usedLetters.contains(letter);
    }

    public Set<Character> getUsedLetters(){
        return new HashSet<>(_usedLetters);
    }

    public Set<Character> getErrorLetters(){
        return new HashSet<>(_errorLetters);
    }

    public int getErrors(){
        return _errorsCount;
    }

    public void addError(Character letter){
        _errorLetters.add(letter);
        _errorsCount++;
    }

    public boolean isWin(){
        return _isWin;
    }

    public void setWin(boolean win){
        _isWin = win;
    }
}