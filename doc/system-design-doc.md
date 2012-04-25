# System Design Document for OH-HAIKU

Version 1.
Author: Jesper Josefsson


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

### Data persistency
A SQLite 3 database will be used to store Twitter tokens, saved Haiku poems