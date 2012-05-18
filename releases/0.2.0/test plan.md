# Test report

##TODOLIST FROM MAX (erase this when done)
 - Skapa en testrapport som för en version av appen går igenom och markerar vilka test som går igenom och vilka som failar. 
 - Gärna i en överskådlig lista som bara refererar till testets ID, resultat och eventuella kommentarer (som om ett test failar pga obefintlig implementation). 
Detta blir relevant när ni har en release.

## Testcases

### 1 Introduction

#### 1.1 Purpose of application
The germ of this application is a tweet. The Swedish comedian Jesper Rönndahl (@jesperronndahl)
tweeted that he often thinks in chunks of three unrelated thoughts. He indicated that he would 
like to have an app that could tell him whether these three sentences constitute a haiku poem.


#### 1.2 General characteristics of application

This application is a simple and easy-to-use poem-checker. It can be used to verify that a piece of text is written according to Haiku-rules and tweet the text. The application is also an easy way to store the users poems.
 
### 2 Test environment
For preparations before testing, see developer's manual.
The .apk file is located in release/0.2.0 map on oh-haiku repository and the code is located in the code directory in the same repository.
To install the .apk file on an emulator, follow this guide: http://blog.freewarelovers.com/2010/08/how-to-install-apk-files-on-android.html
To test Twitter capabilites, Internet access is required.

####2.1 Hardware enviroment
We run our tests on an emulator, using our personal computers (Mac). The emulator's API level is set to 8, platform 2.2.

####2.2 Software environment

####2.2.3 Softwares

Coding:

 - Eclipse SDK Version 3.6 (Helios) or later. 

Mockups:

 - Balsamiq Mockups Version 2.1.16

Code coverage:

 - [EclEmma](http://www.eclemma.org/)

Unit tests:

 - JUnit 3 with Android extensions

####2.2.3 Software settings

### 3 System information

#### 3.1 System version
 Version 0.2.0 of Oh-Haiku is tested.

### 4 Known bugs and limitations
Tweeting an unverified Haiku is possible by loading a verified haiku from database and then editing it manually so that it not a Haiku anymore and pressing the Tweet button.

### 5 Test specification
For documentation on the tests, view [RAD-document with tests](https://github.com/oh-haiku/oh-haiku/blob/master/doc/RAD.md)

### 6 Automatic test

#### 6.1 Code coverage

EclEmma(http://www.eclemma.org/) is used to calculate the code coverage.

The plan is to have 100% coverage on everyting that isn't related to the GUI, in particular unit tests.
The future will tell if this is realistic or not.

For this test, see release 0.2.0 for code coverage statistics.

#### 6.2 Unit test

JUnit 3 with Android extensions will be used for unit testing.

### 7 Test report

