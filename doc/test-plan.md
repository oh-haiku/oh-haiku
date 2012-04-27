# Test plan

## Testcases

### 1 Introduction

#### 1.1 Purpose of application

#### 1.2 General characteristics of application

### 2 Test enviroment

#### T1 General test cases

##### T1.1 Text input
- Description: 
The user should be able to enter text into three text input fields.

- Precondition:
The user starts the app

- Test steps:
Start the app

- Result state:
The user is presented with three text input fields

- Related requirements:
F1.1

##### T1.2 Syllable analysis with live analysis disabled
- Description: 
Text should not be analysed on the fly if live analysis is disabled

- Precondition
T1.1

- Test steps:
  1. Start the app
  2. Disable live analysis
  3. Enter text
  4. Leave text field
  
- Result state:
The user should not be presented with any syllable information or

- Related requirements:
F1.2

##### T1.3 Syllable analysis with live analysis enabled
- Description: 
Text should be analysed on the fly if live analysis is enabled

- Precondition
T1.1

- Test steps:
  1. Start the app
  2. Enable live analysis
  3. Enter text
  4. Leave text field
  
- Result state:
The user is presented with the number of syllables in the text field

- Related requirements:
F1.2

##### T1.4 Haiku analysis button
- Description: 
Haikus analysis should be triggered by the check-button

- Precondition
T1.1 and T1.2 or T1.3

- Test steps:
  1. Start the app
  2. Enter text into the three text fields
  3. Click the Check button
  
- Result state:
The user should be presented with Haiku verification information, true or false

- Related requirements:
F1.3

##### T1.5 Haiku analysis of a valid Haiku
- Description: 
A valid Haiku should be verified as such

- Precondition
T1.1, T1.2 or T1.3 and T1.4

- Test steps:
  1. Start the app
  2. Enter text into the text fields:
      - Hej mitt är Per
      - Jag är inte här just nu
      - Jag var där en gång
  3. Click the Check button
  
- Result state:
The user should told that the Haiku is valid

- Related requirements:
F1.3

##### T1.6 Haiku analysis of an invalid Haiku
- Description: 
A invalid Haiku should be verified as such

- Precondition
T1.1, T1.2 or T1.3 and T1.4

- Test steps:
  1. Start the app
  2. Enter text into the text fields:
      - Detta är för många stavelser
      - En två
      - Att
  3. Click the Check button
  
- Result state:
The user should told that the Haiku is invalid

- Related requirements:
F1.3

#### T2 Twitter test cases
##### T2.1 Tweet the text

- Description: 
When the user presses "Tweet" the text is submitted to Twitter

- Precondition: 
T1.1, T1.3, T2.2 The text-string is written or loaded from saved Haikus and the Haiku is certified correctly. The test checking that the user is logged in with Twitter must be passed.  

- Test steps:
Press "Share", then the options "Tweet", "Send by sms" and "e-mail" should appear. When the user presses "Tweet", the text should be submitted to Twitter if the user is logged in with the Twitter-credentials. 

- Result state:
The text is submitted and the user is informed

- Related requirement
F2.1


##### T2.2 Logging in with Twitter and store user-credentials

- Description: 
The user inserts Twitter-credentials and presses "Log in with Twitter" and has an option to store the credentials. 

- Precondition: 
Start application and press "Settings" should have been tested.  

- Test steps:
The user can insert Twitter-credentials and store them. If the typed Twitter-credentials is wrong in some way (either the username doesn't exist or the password is wrong), the user is informed by some sort of error-message (graphical, sound). If the user presses "remember me" the credentials is stored. 

- Result state:
The user is logged in with Twitter

- Related requirement
F2.2

##### T2.3 Analysis of other users on Twitter, optional

- Description: 
The user clicks on "Check Twitter for #haiku".

- Precondition: 
The user has an internet connection. No twitter account is required.

- Test steps:
If no internet connection is established an error message will be shown.

- Result state:
A list of tweets will be shown in descending order with respect to the creation date.
Next to each tweet a message will be shown notifing the user of the haiku state.

- Related requirement


##### T3.1 Save a haiku
TODO

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

A test framework called (or named) [testng](http://testng.org/doc/index.html) together with JUnit has been chosen for this project.

We can't test the GUI using *testng*, instead something like [robotium](http://code.google.com/p/robotium/) might be used.

### 7 Test report

We'll be using two branches for oh-haiku, one unstable called *master* and one stable(ish) called *stable*.
Both of these will be testet each time something is pushed to Github, but we aren't expecting everyting in *master* to pass.

The *stable* branch should reflect the deployed version (maybe on Google Play). Each release is tagged using *git tags*. Each tag is in it self named according to the [semver](http://semver.org/) version conversion.