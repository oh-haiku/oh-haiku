#Requirements and Analysis Document for OH-Haiku

#1 Introduction
##1.1 Purpose of application
The germ of this application is a tweet. The Swedish comedian Jesper Rönndahl (@jesperronndahl)
tweeted that he often thinks in chunks of three unrelated thoughts. He indicated that he would 
like to have an app that could tell him whether these three sentences constitute a haiku poem.

##1.2 General characteristics of application
This application is a simple and easy-to-use poem-checker. It can be used to verify that a piece of text is written according to Haiku-rules and tweet the text. The application is also an easy way to store the users poems. 
##1.3 Scope of application
Our scope is to let the user be able to write Haikus, save them and tweet them. The Japanese Haiku is written in one single vertical row and the only thing that is counted is the sound of the tokens which means that syllables are ignored. According to the Haiku criterias the Haiku should for example contain a word that refers to a time of year, not be sentimental, not contain too strong adjectives and merge nature observations with the conditions of life. It is nearly impossible to write an algorithm to check those things. Our algorithm focuses on the Western Haiku and therefore on counting syllables.
Only a Swedish language version is planned at the moment. Syllable counting is performed by counting groups of single or consequtive vowels. The algorithm does not handle compound words, i.e. vidareutveckla.

##1.4 Objectives and success criteria of the project
The purpose of this project is the release of the application. The success criteria is that version 1 of the application has been released as an apk package.
##1.5 Definitions, acronyms and abbreviations
 - Certified Haiku - A piece of text divided into three rows, with syllables distributed according to 5-7-5.
 - Non-valid Haiku - Any piece of text with a number of lines not equal to three, or syllables not distributed according to 5-7-5. 
 - Tweet - A post made on the microblogging website Twitter
 - Haiku Composition Activity - The initial view where the user is able to enter a piece of text divided in three rows. 

# 2 Proposed application
## 2.1 Overview
The app shall be able to tell if a piece of text is a haiku. 
The app will help the user to write a haiku by indicating where more syllables are needed
or where they need to be removed.
The user shall be able to tweet his or her haikus.
The app shall let the user save his or her tweets.

## 2.2 Functional requirements

### F1 Basic requirements

#### F1.1 Text input

- Scenario: Text input in the Haiku Composition View
- Trigger: The user starts the application or navigates to the haiku composition view
- Precondition: The application has started
- Basic Path: The user starts the app, clicks on an input field and starts typing
- Postcondition: The user is presented with the Haiku Composition view, which consists of three text input fields. The user can click on an input field and start typing.

#### F1.2 Syllable counting
- Scenario: A text is analysed to give a syllable count
- Trigger: The user leaves a text field and live analysis is enabled, or the user pushes the count-button
- Precondition: F1.1
- Basic Path: F1.1, then the user leaves the text field or pushes the count button. The text contains only valid English or Swedish characters. 
- Exceptional path: F1.1., then the user leaves the text field or pushes the count button. The text contains invalid characters.
- Postcondition:
  - If Basic path: The user is given the syllable count for the given line of text.
  - If Exc. path: The user is given the syllable count, invalid characters are ignored

#### F1.3 Haiku analysis
- Scenario: All three lines of text are analysed for Haiku verification
- Trigger: The user leaves a text field if live analysis is enabled, or the user pushes the Check-button
- Precondition: Text is present in any of the input fields
- Basic Path: The user enters text into any or all text input fields. If live analysis is enabled, the text is analysed for Haiku verification on the fly. Else, the text is analysed when the user pushes the Check-button. 
- Postcondition:
  - The haiku is verified. Either the three lines constitute a Haiku or they don't. The user sees the result.

 
### F2 Twitter requirements
#### F2.1 Tweet the text

- Scenario: 
The user tweets the text.

- Trigger:
The user clicks "Tweet Haiku"

- Precondition: 
F1.1, F1.2, F1.3, F2.2. The user has written a text-string or loaded a saved Haiku and has successfully writing a Verified Haiku. The user is logged in with Twitter. 

- Basic Path:
The text-string is submitted on Twitter when the user has written or has loaded a verified Haiku and clicks "Tweet Haiku" . The tweet follows with a "Certified Haiku"-tag. 

- Exceptional path:
None.

- Post condition:
The user gets some sort of response if the text-string is successfully submitted (graphical, sound)

####F2.2 
- Scenario: 
Logging in with Twitter and store user-credentials

- Trigger:
The user clicks "Log in with Twitter". The user has an option to save the user-credentials by clicking "Remember me"/"Save user-credentials". 

- Precondition: 
The user has launched the application and has clicked on "Settings". 

- Basic Path:
The user launches the application, clicks on Settings and then choose "Log in with Twitter". This is optional which implies that the application can be used without a Twitter-account. The user is also able to click "Remember me"/"Save user-credentials".  

- Exceptional path:
The typed Twitter-credentials is wrong in some way. Either the username doesn't exist or the password is wrong. The user is informed by some sort of error-message (graphical, sound).  

- Post condition:
The user is informed graphically if the application is connected to Twitter. 

####F2.3 Analysis of other users on Twitter, optional

- Scenario: 
Analyse other users on Twitter

- Trigger:
The user clicks "Analyse friends"

- Precondition: 
The user has logged in with Twitter. 

- Basic Path:
The user has logged in with Twitter, clicked on "Analyse friends" and typed a text-string with the friend's username on Twitter 

- Exceptional path:
The friend's username doesn't exist. The user is reported by some error-message. 

- Post condition:
F2.2, Information about the Haiku-tweets-proportion of the friend appears.

### F3 Saving and retrieving haikus

#### F3.1 Save a haiku
- Scenario: Save a haiku
- Trigger: The user clicks the save button in the text input view
- Precondition: The user has entered text into any of the text input fields
- Basic path: The user starts the app, enters some text and pushes the save button
- Exceptional path: There is insufficient space to save the haiku. The user is notified. The haiku is not saved.
- Post condition: The haiku has been saved to the haiku storage and can be accessed later. The GUI informs the user of this. The save-button changes to an update-button

#### F3.2 Browse saved haikus
- Scenario: Browse saved haikus
- Trigger: The user clicks the My saved haikus button in the main menu
- Precondition: N/A
- Basic path: The user starts the app, goes to the menu, selects My saved haikus
- Exceptional path: N/A
- Post condition: The user sees all his or her saved haikus as a list. Each haiku is represented by its first row. Haikus are sorted by date (updated). Symbols next to the haikus reflect if they have been shared in any way. There are separate symbols for twitter, sms and email. The background color of each haiku reflects whether it is a valid haiku.

#### F3.3 Retreive a saved haiku
- Scenario: Retrieve a saved haiku
- Trigger: The user selects a haiku in the My saved haikus view
- Precondition: F3.2
- Basic path: F3.2, then the user selects a haiku
- Post condition: The user is taken to the text input view. The selected haiku has been entered into the text input fields and the save-button has changed into an update-button. 

#### F3.4 Update a haiku
As F3.1, except the Save button is labelled Update and clicking it updates the existing haiku
- Precondition: As 3.1, but the text must have been manipulated after the last save, to be able to press the update-button

#### F3.5 Remove a saved haiku
- Scenario: Remove a saved haiku
- Trigger: The user clicks the remove button for a haiku
- Precondition: The number of saved haikus >= 1
- Basic path: F3.2, then the user clicks the remove button
- Post condition: The haiku is removed from the haiku storage.

### F4 Navigational requirements

####F4.1 Navigation to Menu
- Scenario: Navigation to Menu
- Trigger: The user clicks Menu in the haikuCompositionView
- Precondition: The user has started the application
- Basic path: The user clicks Menu
- Post condition: The application is launched

####F4.2 Navigation to Log in with Twitter
- Scenario: Navigation to Log in with Twitter
- Trigger: The user clicks Log in to Twitter
- Precondition: F4.1
- Basic path: The user clicks menu and Log in to Twitter
- Post condition: The Log-in-to-Twitter-view is shown

####F4.3 Navigation to Help
- Scenario: Navigation to Help
- Trigger: The user clicks Help
- Precondition: F4.1
- Basic path: The user clicks menu and Help
- Post condition: The Help-view is shown

####F4.4 Navigation to My saved Haikus
- Scenario: Navigation to My saved Haikus
- Trigger: The user clicks My saved Haikus
- Precondition: F4.1
- Basic path: The user clicks menu and My saved Haikus
- Post condition: The My saved Haikus-list is shown

####F4.5 Navigation to FAQ
- Scenario: Navigation to FAQ
- Trigger: The user clicks FAQ
- Precondition: F4.1
- Basic path: The user clicks menu and FAQ
- Post condition: The FAQ-view appears

### F5 SMS-related requirements, optional

#### F5.1 Browse the user's SMSes
- Scenario: Browse the user's SMSes
- Trigger: The user clicks the SMSes-button in the main menu
- Precondition: The user has authorized the app to read his or her SMSes
- Basic path: The user starts the app, goes to the main menu and clicks the SMS-button
- Exceptional path: N/A
- Post condition: The user sees a list of his or her SMSes

#### F5.2 Analyze an SMS
- Scenario: Analyze an SMS
- Trigger: The user selects an SMS in the Browse SMSes view
- Precondition: F4.1
- Basic path: F4.1, then selects an SMS and pushes the analyze-button
- Exceptional path: N/A
- Post condition: The user sees the selected SMS, indication whether the SMS is a haiku and the number of syllables on each row.

#### F5.3 Prepare to share a haiku via SMS
- Scenario: Prepare to send a haiku as an SMS
- Trigger: The user clicks the share button and then the Via SMS button in the text input view or when viewing a saved haiku
- Precondition: The users has authorized the app to send SMSes. The user has a saved haiku or has entered text in the text input view
- Basic Path: The user views a saved haiku or is in the text input view. The user then pushes the share button and the Via SMS button.
- Exceptional path: N/A
- Post condition: The user is presented with a preview of the SMS that is to be sent

#### F5.4 Share a haiku via SMS
- Scenario: Send a haiku as an SMS
- Trigger: F4.3
- Precondition: F4.3
- Basic path: The user has reviewed the SMS to be sent, then pushes the Send button
- Exceptional Path: The user chooses to reject the SMS by pushing the cancel button
- Post condition: The user is returned to the parent view. If the user pushed the send button, an SMS is sent. Otherwise, nothing happens.

### F6 Email related requirements, optional
#### F6.1 Share a haiku via email
- Scenario: Prepare to send a haiku as an email
- Trigger: The user clicks the share button and then the Mail button in the text input view or when viewing a saved haiku
- Precondition: The user has a saved haiku or has entered text in the text input view
- Basic Path: The user views a saved haiku or is in the text input view. The user then pushes the share button and the Mail button.
- Exceptional path: N/A
- Post condition: The user is sent to the mail application of the phone, with the haiku inserted in the message body
	
## 2.3 Non-functional requirements

###2.3.1 Usability

- A smooth and nice GUI
- Take Asian influences in consideration when developing the GUI
- Give appropiate sound feedback
- Nice icon
- Lock the GUI as little as possible
- Asynchronous requests when suitable 
- Easy to use for everyone, even people who aren't familiar with Haiku
- There shall always be a cancel button available in all dialogue windows (all scenarios)
- The application shall notify the user at start up if a more recent version of the application exists
- A text that fails Haiku verification should not be tweetable using the application. (Twitter scenario 2.1)

###2.3.2 Reliability

- The Verify Haiku function should never fail! (Verify Haiku scenario 1.2)
- Saved Haikus should not be deletable by mistake 
- The Haiku should not disappear if access to Twitter or Internet is missing

###2.3.3 Performance

- Response time should not be noticeable (all scenarios)
- Verifying if a text is a Haiku should not take more than 10(?) ms (Verify Haiku scenario 1.2)
- Saving a Haiku should not take more than 10 ms (Save a Haiku scenario 3.1)
- Deleting a saved Haiku should not take more than 10 ms (Deleting a Haiku ?)
- Robust
- Resource light, according to Android's demands

###2.3.4 Scalability, Extensibility

- Logic calculating syllables shall be separated from the Haiku logic
- The interface should be designed in a way making it possible to implement other rule based poetry later
- The design should easily be changable so that the rule algorithm can be used in other applications

###2.3.5 Packaging and Installation
- Shall be packaged as a Android application and be released on Google Play
- Shall have a selling description on Google Play

###2.3.6 Accessibility
- Verifying if a text is a Haiku should not require Internet access (Verify Haiku scenario 1.2)
- Saving a Haiku/text should not require Internet access (Save Haiku scenario 3.1)
- Updating to more recent versions of the application should not be required to use the application. (all scenarios)
- Using the application shall not require a twitter account (all scenarios)

###2.3.7 Maintainability
- A clear channel to receive feedback and bug reports
- The application will be updated regularly if demanded

###2.3.8 Legal
- Shall use en suitable license. The MIT license will be used if no conflicts occur, for example from using external libraries. The project may become licensed under a GPL license if necessary

##2.4 Application models 
###2.4.1 Scenarios
In general the user is able to enter a piece of text, check if the text is written according to our Haiku-criterias and if it is, tweet it. The user can log in to Twitter with Twitter credentials and therefore the user doesn't need to go to Twitter to subscribe the Haiku. The user is also able to get help with writing a Haiku, and save and browse written Haikus. 
   
###2.4.2 Use case model Use cases priority
 
###2.4.3 Static model 
###2.4.4 Dynamic model
###2.4.5 User interface
We want to use an attractive UI that is independent of the screen density. The leadwords in the creating process is simplicity, straightness and accessibility. The user should get going quickly and it should be easy to navigate. If the user gets to the menu when starting the application it takes time to get started writing. The user may go to the menu the first time but after that it is essential to be able to write Haikus and tweet them quickly. 

The lotus flower is a persistent feature in the application and it should bring thoughts to Japan.   
## 2.5 Test cases


### T1 General test cases
<br/>

#### T1.1 Text input and clear text input fields
<br/>


#### T1.1.1 Text input
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

#### T1.1.2 Clear all text input fields
- Description: 
The user should be able to clear the text in the three text input fields.

- Precondition:
The user starts the app, the HaikuCompositionActivity appears

- Test steps:
Start the app, write something in the three text input fields. Press "Clear" in the HaikuCompositionActivity

- Result state:
All of the input fields are cleared from text, and the check-lotus-flowers turns grey. You can't save the Haiku directly after clearing

- Related requirements:
F1.1

#### T1.2 Syllable analysis with live analysis disabled
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
The user should not be presented with any syllable information. 

- Related requirements:
F1.2

#### T1.3 Syllable analysis with live analysis enabled
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

#### T1.4 Haiku analysis button
- Description: 
Haikus analysis should be triggered by the check-button

- Precondition
T1.1 and T1.2 or T1.3

- Test steps:
  1. Start the app
  2. Enter text into the three text fields
  3. Click the Check button
  
- Result state:
The user should be presented with Haiku verification information, true or false. Beside each row a lotus-flower turns green if the row is correct. 

- Related requirements:
F1.3

#### T1.5 Haiku analysis of a valid Haiku
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
The user should told that the Haiku is valid and  the lotus-flowers on each row turns green. 

- Related requirements:
F1.3

#### T1.6 Haiku analysis of an invalid Haiku
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
The user should told that the Haiku is invalid,  but the lotus-flower on the third row should turn green (5 syllables=correct). 


- Related requirements:
F1.3

### T2 Twitter test cases
#### T2.1 Tweet the text

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

#### T2.2 Logging in with Twitter and store user-credentials

- Description: 
The user inserts Twitter-credentials and presses "Log in with Twitter" and has an option to store the credentials. 

- Precondition: 
Start application and press Menu->Log in with Twitter should have been tested.  

- Test steps:
The user can insert Twitter-credentials and store them. If the typed Twitter-credentials is wrong in some way (either the username doesn't exist or the password is wrong), the user is informed by some sort of error-message (graphical, sound). If the user presses "remember me" the credentials is stored. 

- Result state:
The user is logged in with Twitter

- Related requirement
F2.2

#### T2.3 Analysis of other users on Twitter, optional

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


###Saving, browsing, retrieving and updating haikus
#### T3.1 Save a haiku
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


#### T3.2 Check for presence of saved haiku

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

#### T3.3 Correct rows of a saved haiku

- Description
Shows which rows that are correct of a saved haiku, in the "My saved Haikus"-list

- Precondition:
T3.1

- Test steps:
  1. T3.1
  2. T4.2
  
- Result state:
The user is in the My saved Haikus view and there is an image with the haiku that reveals which rows that are correctly written. Grey leaves = not valid row. Green leaves = correct row. 

- Related requirements:
F3.1, F3.2

#### T3.4 Browse haikus

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

#### T3.5 Load saved haikus

- Description:
The user can load a saved Haiku into the HaikuCompositionActivity. 

- Precondition:
T3.2, T4.2

- Test steps:
  1. T3.2
  2. T4.2
  3. Load a certain haiku

- Result state:
The chosen haiku is loaded in the HaikuCompositionActivity, and the save-button changes to an update-button. The lotus-flowers indicates which rows that are correctly written. 

- Related requirements:
F3.3

#### T3.6 Update haikus

- Description:
The user can update an already saved haiku or a loaded and manipulated haiku

- Precondition:
T3.1 or T4.3

- Test steps:
  1. T3.1 or T4.3
  2. Click the Update-button when the text is manipulated in some way. The update-button shouldn't be clickable if the text isn't manipulated. 

- Result state:
The user sees "Haiku updated" and the lotus-flowers changes according to the current haiku. 

- Related requirements:
F3.4

#### T3.7 Remove saved haikus

- Description:
The user can remove a saved Haiku

- Precondition:
T3.2, T4.2

- Test steps:
  1. T3.2
  2. T4.2
  3. Click/Swipe a remove-button in the list of My saved haikus to remove a certain haiku

- Result state:
The haiku is removed from the My saved haikus-list. If this is the current haiku in the composition-view, the user of course have to save this haiku to have it in the My saved Haikus again. 

- Related requirements:
F3.5


### T4 Navigational tests

#### T4.1 Menu

- Description:
There is a menu

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button

- Result state:
The user is presented with a menu with 4 menu items: login to twitter, help, browse saved haikus and FAQ

- Related requirements:
F4.1

#### T4.2 Log in to Twitter

- Description:
Log in to Twitter

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button
  3. Click Log in to Twitter

- Result state:
The user is presented with a login-view and is able to enter his/her credentials. 

- Related requirements:
F4.2

#### T4.3 Help

- Description:
There is a Help-function

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button
  3. Click Help

- Result state:
The user is presented with a Help-function with a text explaining how to write a Haiku. 

- Related requirements: F4.3

#### T4.4 My saved Haikus

- Description:
My saved Haikus

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button
  3. Click My saved Haikus

- Result state:
The user is presented with list of the saved Haikus. 

- Related requirements: F4.4

#### T4.5 FAQ

- Description:
There is a FAQ

- Precondition:
N/A

- Test steps:
  1. Start app
  2. Click Menu button
  3. Click FAQ

- Result state:
The user is presented with a FAQ

- Related requirements: F4.5




## 2.6 Possible future directions
In general the possible future directions should focus on developing the Haiku-algorithm.
First and foremost, the algorithm should be able to handle Swedish compound words.
The algorithm could also take artistic values into account, like the following:
 - It contains a word that refers to a time of year 
 - It is divided in two parts in order to surprise 
 - It is not sentimental
 - It merges nature observations with the conditions of life
 - It should be short-spoken and avoid repetition
 - It should not contain personal pronominals
 - It should avoid too strong adjectives
 
Adding additional languages should also be possible.

## 2.7 References
References on the Haiku algorithm:

 - [Svenska Haiku Sällskapet](http://www.haiku-shs.org/shs.htm)
 - [Wikipedias definition av en Haiku](http://sv.wikipedia.org/wiki/Haiku)
 


#3 Architecture
The application is a standard Android application with a database. The database is used to store Haiku poems. The application has modules for counting syllables and checking whether an input string is a valid Haiku. The application adheres to the standard Android MVC pattern. All views have corresponding Activities. Activities communicate with each other using Android Activity Results. The application has modules for Twitter authentication and authorization.

#4 Design
Ready-made syllable counters will be considered. A possible alternative is to use an algorithm that is used in LaTeX. That algorithm is stated in a doctoral dissertation. Finished implementations are already released under the GPL-license. If we will choose that implementation we have to change our choice of license. 

The ORMLite library is used for database interaction. Activities that need to access the database extend the ORMLiteBaseActivity class.

In terms of the Twitter-integration we will consider existing libraries. Twitter4J is a possible alternative. The library manage authorization and authentification with Twitter through OAuth. The license is Apache, which should be compatible with MIT. 
