# Hangman Console

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Complete-success)
![Dependencies](https://img.shields.io/badge/Dependencies-None-lightgrey)

A console implementation of the classic "Hangman" game written in Java. The
player guesses a random Russian word letter by letter, with mistakes
displayed as an ASCII gallows drawing.

This project was built as part of the
[zhukovsd/java-backend-learning-course](https://zhukovsd.github.io/java-backend-learning-course/projects/hangman-console/)
learning track, as a warm-up task for moving from theory to building a
complete application.

## Stack

- Java 25 (uses compact source files / instance main — a `void main()` in
  `Main.java` with no enclosing class, [JEP 512](https://openjdk.org/jeps/512))
- Standard library only (no external dependencies)
- Built manually / via IntelliJ IDEA (no Maven/Gradle)

## Requirements

- **JDK 25** or newer (required for the class-less `void main()` syntax in
  `Main.java`). Earlier Java versions will not compile this file.

## How to run

### Via IntelliJ IDEA
1. Open the project folder as an IntelliJ IDEA project.
2. Make sure `src` is marked as a **Sources Root** and the project JDK is 25+.
3. Run `Main.java`.

### Via terminal
```bash
cd src
javac -d ../out com/github/artemkoloshva/Main.java \
    com/github/artemkoloshva/view/*.java \
    com/github/artemkoloshva/controller/*.java \
    com/github/artemkoloshva/model/*.java \
    com/github/artemkoloshva/util/*.java
cd ..
java -cp out Main
```
> Important: run this from the project root — the path to the dictionary in
> `GameController` is relative to the working directory
> (`src\com\github\artemkoloshva\resources\dictionary.txt`).

## How to play

1. On startup, choose a menu option:
   - `1` — start a new game
   - `2` — exit the application
2. Enter Cyrillic letters one at a time until the word is fully guessed or
   6 mistakes have been made.
3. After the round ends, the app shows the result and the correct word,
   then returns to the main menu.
