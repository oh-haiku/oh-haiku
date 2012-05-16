# System Design Document for OH-HAIKU

Version 1.
Author: Jesper Josefsson

##TODOLIST FROM MAX

 - Intern dependency-analys. Vilka beroenden finns mellan era moduler, vad kan ni påverka, vad kan ni inte påverka pga. Android?
 - Access och security: Vilka krav uppfyller appen i förhållande till Twitters specifikationer?
 - Boundary conditions, finns några? Åtar ni er att hantera input som inte passar för SMS eller Twitter? (Detta är endast ett exempel, försök identifiera fler boundary conditions).
 - Release-procedur (finns inte med i mallen) Beskriv hur en release i ert projekt går till, vad görs i versionshanteringssystemet, vad gör ni med er .apk?

## General information
Oh-Haiku is an Android Application which helps users compose Haiku poems and lets the user save poems and share them via Twitter, SMS or e-mail.

## System composition

### Subsystems
The application is divided into a series of subsystems.

1. Android Activities with corresponding views
   1. Haiku Composition
   2. Main menu
   3. Browse saved Haikus
   4. FAQ/Help
   5. Tweet a Haiku
   5. + TODO: Add further activities
2. Models
   1. Persistency module for saving data such as Haikus and Twitter tokens.
   2. Syllable counting
   3. Haiku verification
   3. Twitter interaction

### Layering
The MVC model is used throughout the system, as per Android standard.

### Class overview

#### Business logic
To allow for the application to support multiple languages, interfaces and abstract superclasses will be defined that will allow classes that are language dependent to be swapped at need.

Abstract classes;
- SyllableCounter
  - Encapsulates a string and applies syllable counting operation upon it
  - Extending classes implement the operations for a particular language
- SyllableCounterFactory
  - Extending classes provide instances of SyllableCounter for a particular language

Classes:
- Haiku
  - Checks whether a poem is a haiku
  - Uses a SyllableCounterFactory to generate new instances of SyllableCounter for a particular language
- Poem
  - Encapsulates three rows of text
  - Serializable for database storage

### Data persistency
A SQLite database will be used to store Twitter tokens, saved Haiku poems

### Testing
JUnit 3 will be used for testing

### Dependencies
The aim has been to solve dependencies using a package manager, for example Maven. This idea is shelved for now, as configuring Maven for Android turned out to be quite tricky.
Instead, 3PP packages will be added as JAR-files.

- ORMLite