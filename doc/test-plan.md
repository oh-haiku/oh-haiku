# Test plan

## Testcases

### 1 Introduction

#### 1.1 Purpose of application
The germ of this application is a tweet. The Swedish comedian Jesper Rönndahl (@jesperronndahl)
tweeted that he often thinks in chunks of three unrelated thoughts. He indicated that he would 
like to have an app that could tell him whether these three sentences constitute a haiku poem.


#### 1.2 General characteristics of application

This application is a simple and easy-to-use poem-checker. It can be used to verify that a piece of text is written according to Haiku-rules and tweet the text. The application is also an easy way to store the users poems.
 
### 2 Test environment


 - Vilka förberedelser behöver göras innan man kan testa
 - Var finns koden eller .apk?
 - Hur installeras denna?
 - Behöver man tömma eller skapa en databas?
 - Behövs internetuppkoppling (kanske ett spciellt nätverk)?

####2.1 Hardware enviroment
We run most of our tests on a HTC-phone and therefore not using the emulator. 

HTC ...
Screen: 


Använder ni emulatorn eller riktig telefon vid dessa?

####2.2 Software environment
(what software (incl version) was used?)
####2.2.3 Softwares

Coding:

 - Eclipse SDK Version 3.6 (Helios) or later. 

Mockups:

 - Balsamiq Mockups Version 2.1.16

Code coverage:

 - [EclEmma](http://www.eclemma.org/)

Nightly builds:

 - [Travis CI](http://travis-ci.org/)

Unit tests:

 - JUnit 3 with Android extensions


GUI-tests:

 - [robotium](http://code.google.com/p/robotium/)






####2.2.3 Software settings

### 3 System information

#### 3.1 System version

### 4 Known bugs and limitations

### 5 Test specification
For documentation on the tests, view [RAD-document with tests](https://github.com/oh-haiku/oh-haiku/blob/master/doc/RAD.md)



### 6 Automatic test

#### 6.1 Code coverage

We've been talking about using something like [EclEmma](http://www.eclemma.org/) to calculate the code coverage.

The plan is to have 100% coverage on everyting that isn't related to the GUI, in particular unit tests.
The future will tell if this is realistic or not.

#### 6.2 Nightly builds

A service named [Travis CI](http://travis-ci.org/) will be used.
Each time something is pushed to Github a [service hook](https://github.com/blog/964-all-of-the-hooks) 
will push the code from GH to Travis CI. TCI will run all test for us, but in a neutral enviroment.

#### 6.3 Unit test

JUnit 3 with Android extensions will be used for unit testing.

We can't test the GUI using *JUnit*, instead something like [robotium](http://code.google.com/p/robotium/) might be used.

### 7 Test report

We'll be using two branches for oh-haiku, one unstable called *master* and one stable(ish) called *stable*.
Both of these will be testet each time something is pushed to Github, but we aren't expecting everyting in *master* to pass.

The *stable* branch should reflect the deployed version (maybe on Google Play). Each release is tagged using *git tags*. Each tag is in it self named according to the [semver](http://semver.org/) version conversion.


FRÅN KURSHEMSIDA:
(present a table with Test id, Result, Comment)
(use comment to say what bug the test resulted in or that the test could not be performed since the requirement is not yet implemented)