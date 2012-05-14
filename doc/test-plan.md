# Test plan

##TODOLIST FROM MAX (erase this when done)
 - Skapa en testrapport som för en version av appen går igenom och markerar vilka test som går igenom och vilka som failar. 
 - Gärna i en överskådlig lista som bara refererar till testets ID, resultat och eventuella kommentarer (som om ett test failar pga obefintlig implementation). 
Detta blir relevant när ni har en release.

## Testcases

### 1 Introduction

#### 1.1 Purpose of application

#### 1.2 General characteristics of application

### 2 Test enviroment


 - Vilka förberedelser behöver göras innan man kan testa
 - Var finns koden eller .apk?
 - Hur installeras denna?
 - Behöver man tömma eller skapa en databas?
 - Behövs internetuppkoppling (kanske ett spciellt nätverk)?

####2.1 Hardware enviroment
(what computers/devices was/wered used?)

Använder ni emulatorn eller riktig telefon vid dessa?

####2.2 Software environment
(what software (incl version) was used?)
####2.2.3 Softwares

####2.2.3 Software settings

### 3 System information

#### 3.1 System version

### 4 Known bugs and limitations

### 5 Test specifcation

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