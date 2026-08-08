package com.github.artemkoloshva.console;

public final class HangmanAscii {
    private static final String[] PICTURES = {
            """
              _______
              |/    |
              |   \s
              |   \s
              |   \s
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |   \s
              |   \s
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |     |
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |    /\s
              |   / \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |    / \\
              |   /   \\
            __|________
            """,
            """
              _______
              |/    |
              |    ^_^
              |    /|\\
              |     |
              |    / \\
            __|________
            """
    };

    private HangmanAscii() {}

    public static String getPicture(int errors) {
        return PICTURES[errors];
    }
}
