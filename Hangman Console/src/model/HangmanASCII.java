package model;

public enum HangmanASCII {
    Stage0("""
              _______
              |/    |
              |   \s
              |   \s
              |   \s
              |   \s
            __|________"""),
    Stage1("""
              _______
              |/    |
              |    ( )
              |   \s
              |   \s
              |   \s
            __|________"""),
    Stage2("""
              _______
              |/    |
              |    ( )
              |     |
              |     |
              |   \s
            __|________"""),
    Stage3("""
              _______
              |/    |
              |    ( )
              |    /|
              |     |
              |   \s
            __|________"""),
    Stage4("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |     |
              |   \s
            __|________"""),
    Stage5("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |    /\s
              |   / \s
            __|________"""),
    Stage6("""
              _______
              |/    |
              |    ( )
              |    /|\\
              |    / \\
              |   /   \\
            __|________"""),
    StageWin("""
              _______
              |/    |
              |    ^_^
              |    /|\\
              |     |
              |    / \\
            __|________""");

    private final String art;

    HangmanASCII(String art) {
        this.art = art;
    }

    public String getArt() {
        return art;
    }
}
