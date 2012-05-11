# Test plan

## Testcases

### 1 Introduction

#### 1.1 Purpose of application

#### 1.2 General characteristics of application

### 2 Test enviroment

#### T1 General test cases
<br/>

##### T1.1 Text input and clear text input fields
<br/>

######T1.1.1 Text input
- Description: 
The user should be able to enter text into three text input fields.

- Precondition:
The user starts the app, the HaikuCompositionActivity appears

- Test steps:
Start the app

- Result state:
The user is presented with three text input fields

- Related requirements:
F1.1

###### T1.1.2 Clear all text input fields
- Description: 
The user should be able to clear the text in the three text input fields.

- Precondition:
The user starts the app, the HaikuCompositionActivity appears

- Test steps:
Start the app, write something in the three text input fields. Press "Clear" in the HaikuCompositionActivity

- Result state:
All of the input fields are cleared from text

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
      - Att apa bepa
  3. Click the Check button
  
- Result state:
The user should told that the Haiku is invalid,  but the third checkbox should be checked (5 syllables=correct). 


- Related requirements:
F1.3

#### T2 Twitter test cases
##### T2.1 Tweet the text

- Description: 
When the user presses "Tweet" the text is submitted to Twitter

- Precondition: 
(T1.1, T1.2 or T1.3, T1.5, T2.2) or (T4.3, T1.5, T2.2) The text-string is written or loaded from saved Haikus and the Haiku is certified correctly. The test checking that the user is logged in with Twitter must be passed.  

- Test steps:
Press "Tweet". When the user presses the button the text should be submitted to Twitter if the user is logged in with the Twitter-credentials. 

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

- Related requirement:


##### T3.1 Save a haiku
- Description:
The user saves a haiku

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Enter text into text fields: "apa", "bepa", "cepa"
  3. Click save

- Result state:
A message "Haiku saved!" appears, and also the save-button turns into a update-button. 

- Related requirement:
F3.1


##### T3.2 Check for presence of saved haiku

- Description
Check that a saved haiku is in the My saved Haikus list

- Precondition:
T3.1

- Test steps:
  1. T3.1
  2. T4.2
  
- Result state:
The user is in the My saved Haikus view and a haiku containing the lines "apa", "bepa", "cepa" is visible

- Related requirements:
F3.1, F3.2

#### T4 Navigational tests

##### T4.1 Menu

- Description:
There is a menu

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button

- Result state:
The user is presented with a menu with 4 menu items: login to twitter, help, browse saved haikus and FAQ

- Related requirements
TODO: should have menu requirements

##### T4.2 Browse haikus

- Description:
The user can browse previously saved haikus

- Precondition:
N/A

- Test steps:
  1. T4.1
  2. Click the My saved Haikus button

- Result state:
The user sees a list of Haikus or the message "No saved Haikus"

- Related requirements:
F3.2

##### T4.3 Load saved haikus

- Description:
The user can load a saved Haiku into the HaikuCompositionActivity. 

- Precondition:
T3.2, T4.2

- Test steps:
  1. T3.2
  2. T4.2
  3. Load a certain haiku

- Result state:
The chosen haiku is loaded in the HaikuCompositionActivity, and the save-button changes to an update-button

- Related requirements:
F3.3

##### T4.4 Update haikus

- Description:
The user can update an already saved haiku or a loaded and manipulated haiku

- Precondition:
T3.1 or T4.3

- Test steps:
  1. T3.1 or T4.3
  2. Click the Update-button when the text is manipulated in some way. The update-button shouldn't be clickable if the text isn't manipulated. 

- Result state:
The user sees "Haiku updated". 

- Related requirements:
F3.4

##### T4.5 Remove saved haikus

- Description:
The user can remove a saved Haiku

- Precondition:
T3.2, T4.2

- Test steps:
  1. T3.2
  2. T4.2
  3. Click/Swipe a remove-button in the list of My saved haikus to remove a certain haiku

- Result state:
The haiku is removed from the My saved haikus-list 

- Related requirements:
F3.5

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