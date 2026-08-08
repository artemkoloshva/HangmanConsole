package com.github.artemkoloshva.model;

public enum HangmanAscii {
    STAGE_0("""
              _______
              |/    |
              |   \s
              |   \s
              |   \s
              |   \s
            __|________"""),
    STAGE_1("""
              _______
              |/    |
              |    ( )
              |   \s
              |   \s
              |   \s
            __|________"""),
    STAGE_2("""
              _______
              |/    |
              |    ( )
              |     |
              |     |
              |   \s
            __|________"""),
    STAGE_3("""
              _______
              |/    |
              |    ( )
              |    /|
              |     |
              |   \s
            __|________"""),
    STAGE_4("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |     |
              |   \s
            __|________"""),
    STAGE_5("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |    /\s
              |   / \s
            __|________"""),
    STAGE_6("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |    / \\
              |   /   \\
            __|________"""),
    STAGE_WIN("""
              _______
              |/    |
              |    ^_^
              |    /|\\
              |     |
              |    / \\
            __|________""");

    private final String art;

    HangmanAscii(String art) {
        this.art = art;
    }

    public String getArt() {
        return art;
    }
}
